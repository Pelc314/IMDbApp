package com.example.imdbapp.domain.model.actor

import com.example.imdbapp.data.remote.dto.actorknownfor.Title
import com.example.imdbapp.data.remote.dto.actorknownfor.WhereToWatch
import com.example.imdbapp.data.remote.dto.searchresultsdto.Summary

data class KnownFor(
    val categories: List<String>? = emptyList(),
    val imdbRating: Double? = 0.0,
    val summary: Summary? = null,
    val title: Title? = null,
    val whereToWatch: WhereToWatch? = null
)
