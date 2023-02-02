package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.domain.model.Actor
import com.example.imdbapp.domain.model.SearchResultsDetails

fun SearchResultsDetails.toActor(): Actor {
    return Actor(
        id = id,
        image = image,
        title = title,
        titleType = titleType,
        year = year,
        name = name,
        knownFor = knownFor
    )
}
