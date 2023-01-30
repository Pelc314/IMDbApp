package com.example.imdbapp.data.mappers

import com.example.imdbapp.data.remote.dto.moviedtos.MovieDetailsDto
import com.example.imdbapp.domain.model.MovieDetails

fun MovieDetailsDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        episode = episode,
        id = id,
        image = image,
        nextEpisode = nextEpisode,
        parentTitle = parentTitle,
        previousEpisode = previousEpisode,
        principals = principals,
        runningTimeInMinutes = runningTimeInMinutes,
        season = season,
        seriesStartYear = seriesStartYear
    )
}
