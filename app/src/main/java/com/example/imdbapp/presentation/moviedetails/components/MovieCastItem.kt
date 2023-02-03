package com.example.imdbapp.presentation.moviedetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun MovieCastItem(
    actorName: String,
    actorsCharacter: String,
    actorsImageUrl: String
) {
    Row() {
        AsyncImage(
            model = "https://m.media-amazon.com/images/M/MV5BMjAwNDU3MzcyOV5BMl5BanBnXkFtZTcwMjc0MTIxMw@@._V1_.jpg",
            contentDescription = "actor thumbnail"
        )
        Column() {
            Text(text = actorName)
            Text(text = "Plays: $actorsCharacter")
        }
    }
}
