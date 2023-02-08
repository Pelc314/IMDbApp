package com.example.imdbapp.data.mappers.actormappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.actordetailsdto.ActorDetailsDto
import com.example.imdbapp.domain.model.actor.Actor
import com.example.imdbapp.domain.model.searchresults.SearchResultsDetails

fun SearchResultsDetails.toActor(): Actor {
    return Actor(
        id = id,
        image = image,
        title = title,
        titleType = titleType,
        year = year,
        name = name,
        knownFor = knownFor?.map { it.toKnownForList() }
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
        realName = realName,
        deathDate = deathDate,
        knownFor = knownFor
    )
}
