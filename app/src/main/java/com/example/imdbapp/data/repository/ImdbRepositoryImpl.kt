package com.example.imdbapp.data.repository

import android.app.Application
import android.util.Log
import com.example.imdbapp.data.mappers.toMovieItem
import com.example.imdbapp.data.remote.IMDbApi
import com.example.imdbapp.domain.model.MovieItem
import com.example.imdbapp.domain.repository.ImdbRepository
import com.example.imdbapp.util.Resource
import com.example.simpleimdbapp.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    override suspend fun getTopRatedMovies(): Resource<List<MovieItem>> {
        return try {
            val result = api.getTopRatedMovies()
            Resource.Success(listOf(result.topMovies))
            Log.e("Did api call work?", "$result")
        } catch (e: HttpException) {
            e.printStackTrace()
            (Resource.Error("Couldn't load data from the API"))
        }
    }
}
}
