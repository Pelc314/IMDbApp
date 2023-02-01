package com.example.imdbapp.presentation.SearchResults

import com.example.imdbapp.domain.model.MovieDetails

data class SearchResultsState(
    val movieDetails: MovieDetails? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
