package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDetailsDto

data class SearchResults(
    val results: List<SearchResultsDetailsDto>
)
