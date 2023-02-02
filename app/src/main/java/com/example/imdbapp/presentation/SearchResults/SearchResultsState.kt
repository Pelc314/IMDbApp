package com.example.imdbapp.presentation.SearchResults

import com.example.imdbapp.domain.model.SearchResultsDetails

data class SearchResultsState(
    val searchResults: List<SearchResultsDetails> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
