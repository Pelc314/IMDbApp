package com.example.imdbapp.data.repository

import android.app.Application
import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.data.mappers.toTopMovie
import com.example.imdbapp.data.remote.IMDbApi
import com.example.imdbapp.domain.model.TopMovie
import com.example.imdbapp.domain.repository.ImdbRepository
import com.example.simpleimdbapp.R
import retrofit2.HttpException
import javax.inject.Inject

class ImdbRepositoryImpl @Inject constructor(
    private val api: IMDbApi,
    private val appContext: Application
) : ImdbRepository {
    init {
        val appName = appContext.getString(R.string.app_name)
    }

    override suspend fun callMostPopularCelebs() {
    }

    override suspend fun getTopRatedMovies(): Resource<List<TopMovie>> {
        return try {
            Resource.Success(data = api.getTopRatedMovies().map { it.toTopMovie() })
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Couldn't get data from the API", null)
        }
    }
}
