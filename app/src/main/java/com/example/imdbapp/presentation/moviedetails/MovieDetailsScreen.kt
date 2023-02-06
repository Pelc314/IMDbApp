package com.example.imdbapp.presentation.moviedetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.imdbapp.presentation.moviedetails.components.MovieCastItem
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun MovieDetailsScreen(
    movieId: String,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(50.dp)
        ) {
            if (!state.isLoading && state.error == "") {
                Text(
                    text = state.movie?.title ?: "null",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 30.sp
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Row() {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(state.movie?.image?.url ?: "null")
                            .crossfade(true)
                            .build(),
                        modifier = Modifier.height(300.dp).width(200.dp)
                            .padding(start = 16.dp),
                        contentDescription = "movie image"
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Release year: ${state.movie?.year ?: "null"}",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "running time: ${state.movie?.runningTimeInMinutes ?: "null"} mins",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Movie rating: to be implemented",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
                Text(
                    text = "Description : to be implemented",
                    modifier = Modifier.padding(start = 16.dp)
                )
                LazyRow() {
                    items(state.movie?.principals?.size ?: 0) { i ->
                        MovieCastItem(
                            actorName = state.movie?.principals?.get(i)?.name ?: "null",
                            actorsCharacter = state.movie?.principals?.get(i)?.characters?.get(0)
                                ?: "null",
                            actorsImageUrl = state.movie?.principals?.get(i)?.id ?: "null",
                            modifier = Modifier.padding(16.dp).clickable { Unit }
                        )
                        if (i < (state.movie?.principals?.size ?: 0)) {
                            Divider(modifier = Modifier.padding(vertical = 16.dp))
                        }
                    }
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (state.isLoading) {
            Column() {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = state.message,
                    color = Color.Red,
                    fontSize = 20.sp
                )
            }
        } else if (state.error != "") {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                fontSize = 20.sp
            )
        }
    }
}
