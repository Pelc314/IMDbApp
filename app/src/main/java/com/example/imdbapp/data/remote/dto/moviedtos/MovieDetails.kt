package com.example.imdbapp.data.remote.dto.moviedtos

data class MovieDetails(
    val episode: Int,
    val id: String,
    val image: Image,
    val nextEpisode: String,
    val parentTitle: ParentTitle,
    val previousEpisode: String,
    val principals: List<Principal>,
    val runningTimeInMinutes: Int,
    val season: Int,
    val seriesStartYear: Int,
    val title: String,
    val titleType: String,
    val year: Int
)
