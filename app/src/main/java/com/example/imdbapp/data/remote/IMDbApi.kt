package com.example.imdbapp.data.remote

import retrofit2.http.GET

interface IMDbApi {
    @GET("actors/list-most-popular-celebs")
    suspend fun callMostPopularCelebs(): List<String>

    companion object {
        const val BASE_URL = "https://imdb8.p.rapidapi.com/"
    }
}
