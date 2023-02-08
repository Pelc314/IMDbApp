package com.example.imdbapp.data.remote.dto.actorknownfor

data class WhereToWatch(
    val freeWithPrime: Boolean,
    val hasDigitalOffers: Boolean,
    val hasPhysicalOffers: Boolean,
    val hasShowtimes: Boolean,
    val hasTvShowings: Boolean,
    val releaseDate: String
)
