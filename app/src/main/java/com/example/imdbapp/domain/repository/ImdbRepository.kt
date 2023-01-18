package com.example.imdbapp.domain.repository

import com.example.imdbapp.domain.model.MovieItem
import com.example.imdbapp.util.Resource

interface ImdbRepository {
    suspend fun callMostPopularCelebs()

    suspend fun getTopRatedMovies(): Resource<List<MovieItem>>
}
