package com.example.imdbapp.data.remote.dto.movieoratingandplotdto

data class Title(
    val id: String,
    val image: Image,
    val nextEpisode: String,
    val numberOfEpisodes: Int,
    val runningTimeInMinutes: Int,
    val seriesEndYear: Int,
    val seriesStartYear: Int,
    val title: String,
    val titleType: String,
    val year: Int
)
