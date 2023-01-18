package com.example.imdbapp.data.remote

import com.squareup.moshi.Json

data class MovieItemDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "chartRating")
    val rating: Double
)
