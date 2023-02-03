package com.example.imdbapp.presentation.moviedetails.previews

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Preview
@Composable
fun MovieCastItemPreview() {
    Row() {
        AsyncImage(
            model = "https://m.media-amazon.com/images/M/MV5BMjAwNDU3MzcyOV5BMl5BanBnXkFtZTcwMjc0MTIxMw@@._V1_.jpg",
            contentDescription = "actor thumbnail"
        )
        Column() {
            Text(text = "Actor Creds")
            Text(text = "Plays as")
        }
    }
}

@Preview
@Composable
fun MovieDetailsScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(50.dp)
        ) {
            Text(
                text = "Good Fellas",
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 30.sp
            )
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
            Row() {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg")
                        .crossfade(true)
                        .build(),
                    modifier = Modifier.height(300.dp).width(200.dp)
                        .padding(start = 16.dp),
                    contentDescription = "movie image"
                )
                Column() {
                    Text(text = "Release year")
                    Text(text = "running time")
                }
            }
            Text(text = "Description")
        }
    }
}
