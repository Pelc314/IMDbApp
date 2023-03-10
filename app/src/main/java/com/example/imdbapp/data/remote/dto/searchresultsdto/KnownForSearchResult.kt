package com.example.imdbapp.data.remote.dto.searchresultsdto

// may cause problems
data class KnownForSearchResult(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val disambiguation: String,
    val id: String,
    val summary: Summary? = null,
    val title: String,
    val titleType: String,
    val year: Int
)
