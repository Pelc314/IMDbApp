package com.example.imdbapp.presentation.moviedetails

import com.example.imdbapp.domain.model.Movie

data class MovieDetailsState(
    val movie: Movie? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
