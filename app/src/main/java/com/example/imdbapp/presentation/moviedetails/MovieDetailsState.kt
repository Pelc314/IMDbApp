package com.example.imdbapp.presentation.moviedetails

import com.example.imdbapp.domain.model.movie.Movie

data class MovieDetailsState(
    val movie: Movie? = null,
    val actorsUrls: List<String>? = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
