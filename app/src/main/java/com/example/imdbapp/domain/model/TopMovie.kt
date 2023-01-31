package com.example.imdbapp.domain.model

data class TopMovie(
    val id: String? = "",
    val chartRating: Double? = null,
    var title: String? = "Default title",
    var imageUrl: String? = ""
)
