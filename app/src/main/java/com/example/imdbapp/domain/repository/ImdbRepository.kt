package com.example.imdbapp.domain.repository

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.MovieDetails
import com.example.imdbapp.domain.model.TopMovie
import kotlinx.coroutines.flow.Flow

interface ImdbRepository {

    suspend fun getTopRatedMovies(): Flow<Resource<List<TopMovie>>>
    suspend fun getMovieDetails(): Flow<Resource<MovieDetails>>
}
