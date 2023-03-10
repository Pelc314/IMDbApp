package com.example.imdbapp.data.mapper.searchresultsmappers // ktlint-disable filename

import com.example.imdbapp.data.mapper.toSearchResultsDetails
import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDto
import com.example.imdbapp.domain.model.searchresults.SearchResults

fun SearchResultsDto.toSearchResults(): SearchResults {
    return SearchResults(
        results = results.map { it.toSearchResultsDetails() }
    )
}
