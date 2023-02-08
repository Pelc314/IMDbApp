package com.example.imdbapp.data.mappers.actormappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDto
import com.example.imdbapp.domain.model.actor.ActorResponse

fun SearchResultsDto.toActorResponse(): ActorResponse {
    return ActorResponse(
        results = results
    )
}
