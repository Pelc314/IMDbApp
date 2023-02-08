package com.example.imdbapp.data.mappers.moviemappers // ktlint-disable filename

import com.example.imdbapp.data.remote.dto.searchresultsdto.SearchResultsDto
import com.example.imdbapp.domain.model.movie.MovieResponse

fun SearchResultsDto.toMovieResponse(): MovieResponse {
    return MovieResponse(
        results = results
    )
}
