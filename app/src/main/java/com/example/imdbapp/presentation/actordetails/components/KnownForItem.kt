package com.example.imdbapp.presentation.actordetails.components

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
import com.example.imdbapp.domain.model.actor.KnownFor

@Composable
fun KnownForItem(
    knownFor: KnownFor,
    modifier: Modifier,
) {
    Row(
        modifier = modifier.background(
            color = Color.LightGray,
            shape = RoundedCornerShape(16.dp),
        ),
    ) {
        Column() {
            CustomAsyncImage(url = knownFor.title?.image?.url ?: "")
        }
        Column() {
            Text(
                text = knownFor.title?.title ?: "",
                modifier = Modifier.padding(start = 16.dp, bottom = 6.dp),
            )
            Text(
                text = knownFor.imdbRating.toString(),
                modifier = Modifier.padding(start = 16.dp, bottom = 6.dp),
            )
            Text(
                text = "Plays as: ${knownFor.summary?.characters?.get(0)}",
                modifier = Modifier.padding(start = 16.dp, bottom = 6.dp),
            )
            Text(
                text = knownFor.summary?.displayYear ?: "",
                modifier = Modifier.padding(start = 16.dp, bottom = 6.dp),
            )
        }
    }
}
