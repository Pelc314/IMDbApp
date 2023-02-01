package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDetailsDto
import com.example.imdbapp.domain.model.Actor

fun SearchResultsDetailsDto.toActor(): Actor {
    return Actor(
        akas = akas,
        id = id,
        image = image,
        title = title,
        titleType = titleType,
        year = year,
        knownFor = knownFor
    )
}
