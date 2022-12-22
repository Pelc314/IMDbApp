package com.example.simpleimdbapp.data.repository

import android.app.Application
import com.example.simpleimdbapp.R
import com.example.simpleimdbapp.data.remote.IMDbApi
import com.example.simpleimdbapp.domain.repository.MyRepository
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
