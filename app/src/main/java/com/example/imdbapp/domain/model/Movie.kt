package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.MovieResultDto

data class Movie(
    val results: List<MovieResultDto>
)
