package com.example.imdbapp.data.remote.dto.movieoratingandplotdto

data class Ratings(
    val canRate: Boolean,
    val otherRanks: List<OtherRank>,
    val rating: Double,
    val ratingCount: Int
)
