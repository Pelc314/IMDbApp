package com.example.imdbapp.presentation.mainscreenwithtopmovies.components

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.imdbapp.core.util.CustomAsyncImage
import com.example.imdbapp.domain.model.movie.TopMovie

@Composable
fun MovieItem(
    movie: TopMovie,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Column(modifier = Modifier.width(250.dp)) {
            Text(
                text = "${movie.title}",
                color = MaterialTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${movie.chartRating}")
        }
        Column(modifier = Modifier.fillMaxSize()) {
            CustomAsyncImage(
                url = movie.imageUrl ?: "",
                modifier = Modifier.size(width = 75.dp, height = 110.dp).align(Alignment.End),
            )
        }
    }
}
