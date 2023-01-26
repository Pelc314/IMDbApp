package com.example.imdbapp.data.repository

import com.example.imdbapp.core.util.Resource
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
    private val api: IMDbApi
//    private val appContext: Application
) : ImdbRepository {
//    init {
//        val appName = appContext.getString(R.string.app_name)
//    }

    override suspend fun callMostPopularCelebs() {
    }

    override suspend fun getTopRatedMovies(): Flow<Resource<List<TopMovie>>> {
        return flow {
            try {
                val topMovies = api.getTopRatedMovies().map { it.toTopMovie() }
                emit(Resource.Success(topMovies))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message() ?: "Unexpected http Error, wrong return code"))
            } catch (e: IOException) {
                emit(Resource.Error(e.message ?: "Unexpected IO exception, check your Internet connection"))
            }
        }
    }
}
