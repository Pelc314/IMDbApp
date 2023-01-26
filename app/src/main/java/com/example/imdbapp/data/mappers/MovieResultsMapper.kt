package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.moviedtos.MovieResultDto
import com.example.imdbapp.domain.model.MovieResults

fun MovieResultDto.toMovieResults(): MovieResults {
    return MovieResults(
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
