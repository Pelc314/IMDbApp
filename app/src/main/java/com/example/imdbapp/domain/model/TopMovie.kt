package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.Image

data class TopMovie(
    val id: String? = null,
    val chartRating: Double? = null,
    var title: String? = "Default title",
    var image: Image? = null
)
