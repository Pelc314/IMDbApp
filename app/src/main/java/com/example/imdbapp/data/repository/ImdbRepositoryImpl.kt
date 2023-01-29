package com.example.imdbapp.data.repository

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.data.local.TopMoviesDatabase
import com.example.imdbapp.data.mappers.toMovie
import com.example.imdbapp.data.mappers.toTopMovie
import com.example.imdbapp.data.remote.IMDbApi
import com.example.imdbapp.domain.model.TopMovie
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImdbRepositoryImpl @Inject constructor(
    private val api: IMDbApi,
    private val db: TopMoviesDatabase
) : ImdbRepository {

    private val dao = db.movieDatabaseDao

    override suspend fun getTopRatedMovies(): Flow<Resource<List<TopMovie>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val topMovies = api.getTopRatedMovies().map { it.toTopMovie() }
                repeat(1) { i -> // repeated only 1 times so it won't use up API monthly quota which is only 500 requests per Month
                    val response = api.findMovie(topMovies[i].id ?: "null")
                        .toMovie().results[0] // results[0] to ensure that the first matching response is downloaded only
                    topMovies[i].image = response.image
                    topMovies[i].title = response.title
                }
                emit(Resource.Success(topMovies))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message() ?: "Unexpected http Error, wrong return code from api"
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected IO exception, check your Internet connection 0_0"
                    )
                )
            }
        }
    }
}
