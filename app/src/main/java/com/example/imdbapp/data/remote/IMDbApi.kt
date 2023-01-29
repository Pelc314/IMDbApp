package com.example.imdbapp.data.remote

import com.example.imdbapp.core.ApiKey
import com.example.imdbapp.data.remote.dto.moviedtos.MovieDto
import com.example.imdbapp.data.remote.dto.topmoviesdtos.TopMovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IMDbApi {
    @GET("actors/list-most-popular-celebs")
    suspend fun callMostPopularCelebs(
        @Query("rapidapi-key") apiKey: String = ApiKey.API_KEY
    ): List<String>

    @GET("title/get-top-rated-movies")
    suspend fun getTopRatedMovies(
        @Query("rapidapi-key") apiKey: String = ApiKey.API_KEY
    ): List<TopMovieDto>

    @GET("title/find")
    suspend fun findMovie(
        @Query("q") searchQuery: String? = null,
        @Query("rapidapi-key") apiKey: String = ApiKey.API_KEY
    ): MovieDto
}
