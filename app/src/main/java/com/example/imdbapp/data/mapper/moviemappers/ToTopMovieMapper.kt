package com.example.imdbapp.data.mapper.moviemappers // ktlint-disable filename

import com.example.imdbapp.data.local.TopMovieEntity
import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDetailsDto
import com.example.imdbapp.data.remote.dto.topmoviesdto.TopMovieDto
import com.example.imdbapp.domain.model.movie.TopMovie

fun TopMovieDto.toTopMovie(): TopMovie {
    return TopMovie(
        chartRating = chartRating,
        id = id.split('/')
            .get(2), // this is done because of weird API response which includes redundant chars.
    )
}

fun TopMovieEntity.toTopMovie(): TopMovie {
    return TopMovie(
        chartRating = chartRating,
        title = title,
        imageUrl = imageUrl,
        id = id,
    )
}

fun TopMovie.toTopMovieEntity(): TopMovieEntity {
    return TopMovieEntity(
        imageUrl = imageUrl,
        title = title,
        chartRating = chartRating,
        id = id,
    )
}

fun SearchResultsDetailsDto.toTopMovie(): TopMovie {
    return TopMovie(
        id = id.split('/').get(2),
        imageUrl = image.url,
        chartRating = chartRating?.rating ?: 0.0,
        title = title,
    )
}
