package com.example.imdbapp.data.repository

import android.app.Application
import com.example.imdbapp.data.remote.IMDbApi
import com.example.imdbapp.domain.repository.MyRepository
import com.example.simpleimdbapp.R
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: IMDbApi,
    private val appContext: Application
) : MyRepository {
    init {
        val appName = appContext.getString(R.string.app_name)
    }
    override suspend fun callMostPopularCelebs() {
    }
}
