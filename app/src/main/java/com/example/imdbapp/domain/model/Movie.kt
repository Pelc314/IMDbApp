package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.moviedtos.SearchResultDetailsDto

data class Movie(
    val results: List<SearchResultDetailsDto>
)
