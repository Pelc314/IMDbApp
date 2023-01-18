package com.example.imdbapp.data.remote.dto

import com.example.imdbapp.domain.model.TopMovie

data class TopMovieDto(
    val chartRating: Double,
    val id: String
) {
    fun toTopMovie(): TopMovie {
        return TopMovie(
            chartRating = chartRating,
            id = id
        )
    }
}
