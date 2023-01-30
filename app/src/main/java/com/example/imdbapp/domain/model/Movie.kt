package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.MovieDetails

data class Movie(
    val results: List<MovieDetails>
)
