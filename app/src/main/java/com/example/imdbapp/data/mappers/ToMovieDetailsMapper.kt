package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.moviedtos.SearchResultDetailsDto
import com.example.imdbapp.domain.model.MovieDetails

fun SearchResultDetailsDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        episode = episode,
        id = id,
        image = image,
        nextEpisode = nextEpisode,
//        parentTitle = parentTitle,
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
