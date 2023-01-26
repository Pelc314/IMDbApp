package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.moviedtos.MovieDto
import com.example.imdbapp.domain.model.Movie

fun MovieDto.toMovie(): Movie {
    return Movie(
        results = results
    )
}
