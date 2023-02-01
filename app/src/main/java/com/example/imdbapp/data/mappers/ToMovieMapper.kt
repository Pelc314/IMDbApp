package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDetailsDto
import com.example.imdbapp.domain.model.Movie

fun SearchResultsDetailsDto.toMovie(): Movie {
    return Movie(
        episode = episode,
        id = id,
        image = image,
        nextEpisode = nextEpisode,
        previousEpisode = previousEpisode,
        principals = principals,
        runningTimeInMinutes = runningTimeInMinutes,
        season = season,
        seriesStartYear = seriesStartYear,
        title = title,
        titleType = titleType,
        year = year
    )
}
