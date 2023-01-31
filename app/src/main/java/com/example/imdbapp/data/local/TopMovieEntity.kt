package com.example.imdbapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// This entity represents data inserted into database which is needed to load top movies to the home screen.
@Entity
data class TopMovieEntity(
    @PrimaryKey val DbId: Int? = null,
    val imageUrl: String? = "",
    val title: String? = "Default title",
    val chartRating: Double? = 0.0,
    val id: String? = ""
)
