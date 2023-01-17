package com.example.imdbapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface IMDbApi {
    @GET("actors/list-most-popular-celebs")
    suspend fun callMostPopularCelebs(
        @Query("rapidapi-key") apiKey: String = API_KEY
    ): List<String>

    companion object {
        const val BASE_URL = "https://imdb8.p.rapidapi.com/"
        const val API_KEY = "https://imdb8.p.rapidapi.com/"
    }
}
