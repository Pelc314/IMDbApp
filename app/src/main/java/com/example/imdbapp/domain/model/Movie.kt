package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.MovieResult

data class Movie(
    val results: List<MovieResult>
)
