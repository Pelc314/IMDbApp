package com.example.imdbapp.data.remote.dto.moviedtos

data class SearchResultDto(
    val meta: Meta,
    val type: String,
    val query: String,
    val results: List<SearchResultDetailsDto>,
    val types: List<String>
)
