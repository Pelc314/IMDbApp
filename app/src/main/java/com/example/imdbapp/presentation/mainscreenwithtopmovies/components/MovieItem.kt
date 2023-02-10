package com.example.imdbapp.presentation.mainscreenwithtopmovies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.imdbapp.core.util.CustomAsyncImage

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movieItemState: MovieItemState,
) {
    Row(
        modifier = modifier.background(color = Color.LightGray, shape = RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        if (movieItemState.isLoading) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .height(110.dp),
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 35.dp),
                )
            }
        } else if (movieItemState.error == "") {
            Column(modifier = Modifier.width(250.dp)) {
                Text(
                    text = movieItemState.topRatedMovieItem?.title ?: "Unknown",
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(start = 10.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${movieItemState.topRatedMovieItem?.chartRating ?: "Unknown rating"}",
                    modifier = Modifier.padding(start = 10.dp),
                )
            }
            Column(modifier = Modifier.fillMaxSize()) {
                CustomAsyncImage(
                    url = movieItemState.topRatedMovieItem?.imageUrl ?: "",
                    modifier = Modifier
                        .size(width = 75.dp, height = 110.dp)
                        .align(Alignment.End),
                )
            }
        }
        if (movieItemState.error != "") {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .height(110.dp),
            ) {
                Text(
                    text = movieItemState.error,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 35.dp),
                )
            }
        }
    }
}
