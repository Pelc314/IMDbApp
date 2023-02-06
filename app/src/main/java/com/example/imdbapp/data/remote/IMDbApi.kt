package com.example.imdbapp.data.remote

import com.example.imdbapp.core.ApiKey
import com.example.imdbapp.data.remote.dto.movieoratingandplotdto.MovieDetailsDto
import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDto
import com.example.imdbapp.data.remote.dto.topmoviesdto.TopMovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IMDbApi {

    @GET("title/get-top-rated-movies")
    suspend fun getTopRatedMovies(
        @Query("rapidapi-key") apiKey: String = ApiKey.API_KEY
    ): List<TopMovieDto>

    @GET("title/find")
    suspend fun findMovieorActor(
        @Query("q") searchQuery: String? = null,
        @Query("rapidapi-key") apiKey: String = ApiKey.API_KEY
    ): SearchResultsDto

    @GET("title/get-overview-details")
    suspend fun getOverviewDetails(
        @Query("tconst") movieId: String? = null,
        @Query("rapidapi-key") apiKey: String = ApiKey.API_KEY
    ): MovieDetailsDto
}
