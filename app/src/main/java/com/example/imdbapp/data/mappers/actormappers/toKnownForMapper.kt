package com.example.imdbapp.data.mappers.actormappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.actorknownfor.KnownForDto
import com.example.imdbapp.data.remote.dto.searchresultsdto.KnownForSearchResult
import com.example.imdbapp.domain.model.actor.KnownFor

fun KnownForDto.toKnownFor(): KnownFor {
    return KnownFor(
        categories = categories,
        imdbRating = imdbRating,
        summary = summary,
        title = title,
        whereToWatch = whereToWatch
    )
}

fun KnownForSearchResult.toKnownForList(): KnownFor {
    return KnownFor(
        summary = summary
    )
}
