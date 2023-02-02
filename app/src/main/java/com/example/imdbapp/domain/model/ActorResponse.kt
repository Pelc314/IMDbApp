package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDetailsDto

data class ActorResponse(
    val results: List<SearchResultsDetailsDto>
)
