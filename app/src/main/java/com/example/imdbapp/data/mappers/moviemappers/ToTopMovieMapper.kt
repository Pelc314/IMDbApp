package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.local.TopMovieEntity
import com.example.imdbapp.data.remote.dto.topmoviesdto.TopMovieDto
import com.example.imdbapp.domain.model.TopMovie

fun TopMovieDto.toTopMovie(): TopMovie {
    return TopMovie(
        chartRating = chartRating,
        id = id.split('/').get(2).toString() // this is done because of weird API response which includes redundant chars.
    )
}

fun TopMovieEntity.toTopMovie(): TopMovie {
    return TopMovie(
        chartRating = chartRating,
        title = title,
        imageUrl = imageUrl,
        id = id
    )
}

fun TopMovie.toTopMovieEntity(): TopMovieEntity {
    return TopMovieEntity(
        imageUrl = imageUrl,
        title = title,
        chartRating = chartRating,
        id = id
    )
}
