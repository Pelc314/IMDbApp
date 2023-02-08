package com.example.imdbapp.data.remote.dto.actorknownfor

import com.example.imdbapp.data.remote.dto.searchresultsdto.Summary

data class KnownForDto(
    val categories: List<String>,
    val imdbRating: Double,
    val summary: Summary,
    val title: Title,
    val whereToWatch: WhereToWatch
)
