package com.example.imdbapp.domain.model.actor

import com.example.imdbapp.data.remote.dto.actordetailsdto.MiniBio
import com.example.imdbapp.data.remote.dto.searchresultsdto.Image

data class Actor(
    val id: String? = "",
    val image: Image? = null,
    val title: String? = "",
    val titleType: String? = "",
    val year: Int? = 0,
    val name: String? = "Default name",
    val knownFor: List<KnownFor>? = emptyList(),
    val birthDate: String? = "",
    val birthPlace: String? = "",
    val heightCentimeters: Double? = 0.0,
    val miniBios: List<MiniBio>? = emptyList(),
    val trademarks: List<String>? = emptyList(),
    val nicknames: List<String>? = emptyList(),
    val realName: String? = "",
    val deathDate: String? = ""
)
