package com.example.imdbapp.data.remote.dto.moviedtos

data class Principal(
    val billing: Int,
    val category: String,
    val characters: List<String>,
    val disambiguation: String,
    val id: String,
    val legacyNameText: String,
    val name: String,
    val roles: List<Role>
)
