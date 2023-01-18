package com.example.imdbapp.domain.repository

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.domain.model.TopMovie

interface ImdbRepository {
    suspend fun callMostPopularCelebs()

    suspend fun getTopRatedMovies(): Resource<List<TopMovie>>
}
