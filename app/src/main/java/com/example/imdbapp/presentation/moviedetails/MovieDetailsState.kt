package com.example.imdbapp.presentation.moviedetails

import com.example.imdbapp.domain.model.MovieDetails

data class MovieDetailsState(
    val movieDetails: MovieDetails? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
