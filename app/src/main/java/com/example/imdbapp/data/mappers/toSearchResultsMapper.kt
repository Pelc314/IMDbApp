package com.example.imdbapp.data.mappers // ktlint-disable filename

import android.util.Log
import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDto
import com.example.imdbapp.domain.model.SearchResults

fun SearchResultsDto.toSearchResults(): SearchResults {
    Log.d("searchResultsmapper", "${results[0].title}")
    return SearchResults(
        results = results
    )
}
