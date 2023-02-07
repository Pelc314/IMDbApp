package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.actordetailsdto.ActorDetailsDto
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

fun ActorDetailsDto.toActorDetails(): Actor {
    return Actor(
        id = id,
        image = image,
        birthDate = birthDate,
        birthPlace = birthPlace,
        heightCentimeters = heightCentimeters,
        miniBios = miniBios,
        name = name,
        trademarks = trademarks,
        nicknames = nicknames,
        realName = realName
    )
}
