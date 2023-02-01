package com.example.imdbapp.data.repository

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.data.local.TopMoviesDatabase
import com.example.imdbapp.data.mappers.toMovie
import com.example.imdbapp.data.mappers.toMovieDetails
import com.example.imdbapp.data.mappers.toTopMovie
import com.example.imdbapp.data.mappers.toTopMovieEntity
import com.example.imdbapp.data.remote.IMDbApi
import com.example.imdbapp.domain.model.MovieDetails
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


    override suspend fun getSearchResults(query: String):Flow<Resource<SearchResults>> {

    }

    override suspend fun getTopRatedMovies(): Flow<Resource<List<TopMovie>>> {
        return flow {
            emit(Resource.Loading())
            val localResponseTopMovies = dao.getTopMovies().map { it.toTopMovie() }
            if (!localResponseTopMovies.isEmpty()) {
                emit(Resource.Success(data = localResponseTopMovies))
                return@flow
            }
            try {
                var topMoviesRemote: List<TopMovie> = api.getTopRatedMovies()
                    .map { it.toTopMovie() } // this gets list of topMovies from the remote API, unfortunately this endpoint doesn't contain data about thumbnails
                topMoviesRemote = topMoviesRemote.dropLast(240)
                repeat(topMoviesRemote.size) { i ->
                    val remoteResponseTopMovie = api.findMovie(topMoviesRemote[i].id ?: "null")
                        .toMovie()
                        .results[0]
                    topMoviesRemote[i].imageUrl = remoteResponseTopMovie.image?.url
                    topMoviesRemote[i].title = remoteResponseTopMovie.title
                }
                emit(Resource.Success(topMoviesRemote))
                topMoviesRemote.let { topMovies ->
                    dao.clearTopMovies()
                    dao.insertTopMovies(topMovies.map { it.toTopMovieEntity() })
                }
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message() ?: "Unexpected http Error, wrong return code from HTTP"
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

    override suspend fun getMovieDetails(query: String): Flow<Resource<MovieDetails>> {
        return flow {
            emit(Resource.Loading())
            try {
                val movie = api.findMovie(query)
                    .toMovie()
                    .results[0]
                val movieDetails = movie.toMovieDetails()
                emit(Resource.Success(data = movieDetails))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message() ?: "Unexpected http Error, wrong return code from HTTP"
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
