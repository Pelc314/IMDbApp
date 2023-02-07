package com.example.imdbapp.data.remote.dto.actorknownfor

data class KnownForDto(
    val categories: List<String>,
    val imdbRating: Double,
    val summary: Summary,
    val title: Title,
    val whereToWatch: WhereToWatch
)
