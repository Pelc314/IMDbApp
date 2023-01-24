package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.TopMovieDto
import com.example.imdbapp.domain.model.TopMovie

fun TopMovieDto.toTopMovie(): TopMovie {
    return TopMovie(
        chartRating = chartRating,
        id = id
    )
}
