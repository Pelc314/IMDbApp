package com.example.imdbapp.data.remote.dto.moviedtos

data class KnownFor(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val disambiguation: String,
    val id: String,
    val summary: Summary,
    val title: String,
    val titleType: String,
    val year: Int
)