package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.MovieDetailsDto

data class Movie(
    val results: List<MovieDetailsDto>
)
