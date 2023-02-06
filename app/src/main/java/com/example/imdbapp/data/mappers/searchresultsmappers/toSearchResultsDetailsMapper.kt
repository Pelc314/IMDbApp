package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDetailsDto
import com.example.imdbapp.domain.model.SearchResultsDetails

// ktlint-disable filename

fun SearchResultsDetailsDto.toSearchResultsDetails(): SearchResultsDetails {
    return SearchResultsDetails(
        akas = akas,
        episode = episode,
        id = id.split('/').get(2).toString(),
        image = image,
        knownFor = knownFor,
        nextEpisode = nextEpisode,
        parentTitle = parentTitle,
        previousEpisode = previousEpisode,
        principals = principals,
        runningTimeInMinutes = runningTimeInMinutes,
        season = season,
        seriesStartYear = seriesStartYear,
        title = title,
        titleType = titleType,
        year = year,
        name = name,
        chartRating = chartRating,
        description = description
    )
}
