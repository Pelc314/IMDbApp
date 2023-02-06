package com.example.imdbapp.data.remote.dto.movieoratingandplotdto

data class MovieDetailsDto(
    val certificates: Certificates,
    val genres: List<String>,
    val id: String,
    val plotOutline: PlotOutline,
    val plotSummary: PlotSummary,
    val ratings: Ratings,
    val releaseDate: String,
    val title: Title
)
