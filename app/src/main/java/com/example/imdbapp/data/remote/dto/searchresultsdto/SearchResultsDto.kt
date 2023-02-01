package com.example.imdbapp.data.remote.dto.searchresultsdto

data class SearchResultsDto(
    val meta: Meta,
    val type: String,
    val query: String,
    val results: List<SearchResultsDetailsDto>,
    val types: List<String>
)
