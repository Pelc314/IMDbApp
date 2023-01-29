package com.example.imdbapp.data.remote.dto.moviedtos

data class MovieDto(
    val meta: Meta,
    val type: String,
    val query: String,
    val results: List<MovieResult>,
    val types: List<String>
)
