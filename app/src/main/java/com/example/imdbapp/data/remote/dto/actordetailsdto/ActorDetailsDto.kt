package com.example.imdbapp.data.remote.dto.actordetailsdto

import com.example.imdbapp.data.remote.dto.searchresultsdto.Image

data class ActorDetailsDto(
    val akas: List<String>,
    val birthDate: String,
    val birthPlace: String,
    val gender: String,
    val heightCentimeters: Double,
    val id: String,
    val image: Image,
    val legacyNameText: String,
    val miniBios: List<MiniBio>,
    val name: String,
    val nicknames: List<String>,
    val realName: String,
    val spouses: List<Spouse>,
    val trademarks: List<String>
)
