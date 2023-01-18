package com.example.imdbapp.data.mappers

import com.example.imdbapp.data.remote.MovieItemDto
import com.example.imdbapp.data.remote.TopMoviesListDto
import com.example.imdbapp.domain.model.MovieItem

private data class IndexedMovies(
    val index: Int,
    val data: MovieItem
)

fun MovieItemDto.toMovieItem(): MovieItem {
    return MovieItem(
        id = id,
        chartRating = rating
    )
}

//fun TopMoviesListDto.toTopMoviesMap(): Map<Int, List<MovieItem>> {
//}
