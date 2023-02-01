package com.example.imdbapp.data.remote.dto.moviedtos

import com.example.imdbapp.data.remote.dto.searchresultsactordtos.Role

data class Cast(
    val `as`: String,
    val billing: Int,
    val category: String,
    val characters: List<String>,
    val endYear: Int,
    val episodeCount: Int,
    val roles: List<Role>,
    val startYear: Int
)