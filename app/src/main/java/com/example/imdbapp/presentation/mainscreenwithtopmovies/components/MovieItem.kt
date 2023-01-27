package com.example.imdbapp.presentation.mainscreenwithtopmovies

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.imdbapp.domain.model.TopMovie

@Composable
fun MovieItem(
    movie: TopMovie,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.wrapContentWidth().padding(15.dp)) {
            Text(
                text = "${movie.title}",
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${movie.chartRating}")
        }
        AsyncImage(model = "${movie.image?.url}", contentDescription = "movie thumbnail")
    }
}
