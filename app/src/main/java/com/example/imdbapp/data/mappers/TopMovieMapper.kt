package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.topmoviesdtos.TopMovieDto
import com.example.imdbapp.domain.model.TopMovie

fun TopMovieDto.toTopMovie(): TopMovie {
    return TopMovie(
        chartRating = chartRating,
        id = id.dropLast(1).drop(7) // this is done because of weird API response which includes redundant chars.
    )
}
