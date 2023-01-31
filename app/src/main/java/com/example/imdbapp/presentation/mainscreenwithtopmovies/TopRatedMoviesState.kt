package com.example.imdbapp.presentation.mainscreenwithtopmovies

import com.example.imdbapp.domain.model.TopMovie

data class TopRatedMoviesState(
    val topRatedMovies: List<TopMovie> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
