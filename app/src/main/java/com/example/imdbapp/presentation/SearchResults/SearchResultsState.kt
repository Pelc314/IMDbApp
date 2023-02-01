package com.example.imdbapp.presentation.SearchResults

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDetailsDto

data class SearchResultsState(
    val searchResults: List<SearchResultsDetailsDto> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = "",
    val error: String = "",
    val message: String = ""
)
