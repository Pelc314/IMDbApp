package com.example.imdbapp.data.remote.dto.searchresultsdto

data class SearchResultsDetailsDto(
    val akas: List<String> = emptyList(),
    val episode: Int = 0,
    val id: String = "",
    val image: Image,
    val knownFor: List<KnownFor> = emptyList(),
    val nextEpisode: String = "",
    val parentTitle: ParentTitle,
    val previousEpisode: String = "",
    val principals: List<Principal> = emptyList(),
    val runningTimeInMinutes: Int = 0,
    val season: Int = 0,
    val seriesStartYear: Int = 0,
    val title: String = "",
    val titleType: String = "",
    val year: Int = 0
)
