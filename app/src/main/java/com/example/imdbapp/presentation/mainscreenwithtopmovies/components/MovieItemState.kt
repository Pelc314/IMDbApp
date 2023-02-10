package com.example.imdbapp.presentation.mainscreenwithtopmovies.components

import com.example.imdbapp.domain.model.movie.TopMovie

data class MovieItemState(
    val topRatedMovieItem: TopMovie? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    var searchQuery: String = "",
    val error: String = "",
    val message: String = "",
)
