package com.example.imdbapp.presentation.mainscreenwithtopmovies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        Column(modifier = modifier) {
            Text(
                text = "${movie.title}",
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${movie.chartRating}")
        }
    }
}
