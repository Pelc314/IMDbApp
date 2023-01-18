package com.example.imdbapp.presentation

import com.example.imdbapp.domain.model.TopMovie

data class TopRatedMoviesState(
    val topRatedMovies: List<TopMovie> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
