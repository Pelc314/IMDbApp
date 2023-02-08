package com.example.imdbapp.domain.model.searchresults

import com.example.imdbapp.data.remote.dto.movieoratingandplotdto.PlotOutline
import com.example.imdbapp.data.remote.dto.movieoratingandplotdto.Ratings
import com.example.imdbapp.data.remote.dto.searchresultsdto.Image
import com.example.imdbapp.data.remote.dto.searchresultsdto.KnownForSearchResult
import com.example.imdbapp.data.remote.dto.searchresultsdto.ParentTitle
import com.example.imdbapp.data.remote.dto.searchresultsdto.Principal

data class SearchResultsDetails(
    val akas: List<String>? = emptyList(),
    val episode: Int? = 0,
    val id: String? = "default id",
    val image: Image?,
    val knownFor: List<KnownForSearchResult>? = emptyList(),
    val nextEpisode: String? = "",
    val parentTitle: ParentTitle?,
    val previousEpisode: String? = "",
    val principals: List<Principal>? = emptyList(),
    val runningTimeInMinutes: Int? = 0,
    val season: Int? = 0,
    val seriesStartYear: Int? = 0,
    val title: String? = "default title",
    val titleType: String? = "",
    val year: Int? = 0,
    val name: String? = "default name",
    val chartRating: Ratings? = null,
    val description: PlotOutline? = null

)
