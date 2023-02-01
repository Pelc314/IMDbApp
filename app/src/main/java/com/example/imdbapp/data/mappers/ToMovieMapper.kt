package com.example.imdbapp.data.mappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.moviedtos.SearchResultDto
import com.example.imdbapp.domain.model.Movie

fun SearchResultDto.toMovie(): Movie {
    return Movie(
        results = results
    )
}
