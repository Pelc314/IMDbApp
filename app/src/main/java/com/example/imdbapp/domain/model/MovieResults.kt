package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.Image
import com.example.imdbapp.data.remote.dto.moviedtos.Principal

data class MovieResults(
    val image: Image,
    val nextEpisode: String,
    val previousEpisode: String,
    val principals: List<Principal>,
    val runningTimeInMinutes: Int,
    val season: Int,
    val seriesStartYear: Int,
    val title: String,
    val titleType: String, // is it a movie or a series
    val year: Int
)
