package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.movieoratingandplotdto.PlotOutline
import com.example.imdbapp.data.remote.dto.movieoratingandplotdto.Ratings
import com.example.imdbapp.data.remote.dto.searchresultsdto.Image
import com.example.imdbapp.data.remote.dto.searchresultsdto.Principal

data class Movie(
    val episode: Int? = 0,
    val id: String? = "default id",
    val image: Image?,
    val nextEpisode: String? = "",
    val previousEpisode: String? = "",
    val principals: List<Principal>? = emptyList(),
    val runningTimeInMinutes: Int? = 0,
    val season: Int? = 0,
    val seriesStartYear: Int? = 0,
    val title: String? = "default title",
    val titleType: String? = "default title type",
    val year: Int? = 0,
    var chartRating: Ratings? = null,
    var description: PlotOutline? = null
)
