package com.example.imdbapp.data.remote

import com.example.imdbapp.data.remote.dto.TopMovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IMDbApi {
    @GET("actors/list-most-popular-celebs")
    suspend fun callMostPopularCelebs(
        @Query("rapidapi-key") apiKey: String = API_KEY
    ): List<String>

    @GET("title/get-top-rated-movies")
    suspend fun getTopRatedMovies(
        @Query("rapidapi-key") apiKey: String = API_KEY
    ): List<TopMovieDto>

    companion object {
        const val BASE_URL = "https://imdb8.p.rapidapi.com/"
        const val API_KEY = "5f50fb1401msh8e2bb9a7b7acbb4p1ce086jsnd514f3853626"
    }
}
