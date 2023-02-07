package com.example.imdbapp.presentation.moviedetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MovieCastItem(
    actorName: String,
    actorsCharacter: String,
    actorsImageUrl: String,
    modifier: Modifier
) {
    Row(modifier = modifier) {
        AsyncImage(
            model = actorsImageUrl,
            contentDescription = "actor thumbnail"
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = actorName, modifier = Modifier.padding(bottom = 16.dp))
            Text(text = "Plays: $actorsCharacter")
        }
    }
}
