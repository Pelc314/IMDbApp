package com.example.imdbapp.domain.model

import com.example.imdbapp.data.remote.dto.searchresultsdto.Image
import com.example.imdbapp.data.remote.dto.searchresultsdto.KnownFor

data class Actor(
    val id: String? = "",
    val image: Image?,
    val title: String? = "",
    val titleType: String? = "",
    val year: Int? = 0,
    val name: String? = "",
    val knownFor: List<KnownFor>? = emptyList()
)
