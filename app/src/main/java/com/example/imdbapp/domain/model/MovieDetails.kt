package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.Image
import com.example.imdbapp.data.remote.dto.moviedtos.Principal

data class MovieDetails(
    val episode: Int? = 0,
    val id: String? = "",
    val image: Image?,
    val nextEpisode: String? = "",
//    val parentTitle: ParentTitle,
    val previousEpisode: String? = "",
    val principals: List<Principal>,
    val runningTimeInMinutes: Int? = 0,
    val season: Int? = 0,
    val seriesStartYear: Int? = 0,
    val title: String? = "",
    val titleType: String? = "",
    val year: Int? = 0
)
