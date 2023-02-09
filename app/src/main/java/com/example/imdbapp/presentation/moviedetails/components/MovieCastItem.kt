package com.example.imdbapp.presentation.moviedetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.imdbapp.core.util.CustomAsyncImage

@Composable
fun MovieCastItem(
    actorName: String,
    actorsCharacter: String,
    actorsImageUrl: String,
    modifier: Modifier,
) {
    Row(
        modifier = modifier.background(
            color = Color.LightGray,
            shape = RoundedCornerShape(16.dp),
        ),
    ) {
        CustomAsyncImage(url = actorsImageUrl)
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = actorName, modifier = Modifier.padding(bottom = 16.dp, top = 16.dp))
            Text(text = "Plays: $actorsCharacter", modifier = Modifier.padding(end = 16.dp))
        }
    }
}
