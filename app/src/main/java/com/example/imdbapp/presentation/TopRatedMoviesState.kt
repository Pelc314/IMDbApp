package com.example.imdbapp.presentation

import com.example.imdbapp.domain.model.MovieItem

data class TopRatedMoviesState(
    val topRatedMovies: List<MovieItem> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
