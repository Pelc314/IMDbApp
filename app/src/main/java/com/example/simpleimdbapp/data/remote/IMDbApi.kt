package com.example.simpleimdbapp.data.remote

import retrofit2.http.GET

interface IMDbApi {
    @GET("actors/list-most-popular-celebs")
    suspend fun callMostPopularCelebs() {
    }
}
