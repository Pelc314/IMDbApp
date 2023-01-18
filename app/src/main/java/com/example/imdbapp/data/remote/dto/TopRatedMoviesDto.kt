package com.example.imdbapp.data.remote.dto

import com.example.imdbapp.domain.model.TopMovie

data class TopRatedMoviesDto(
    val chartRating: Double,
    val id: String
) {
    fun toMovie(): TopMovie {
        return TopMovie(
            chartRating = chartRating,
            id = id
        )
    }
}
