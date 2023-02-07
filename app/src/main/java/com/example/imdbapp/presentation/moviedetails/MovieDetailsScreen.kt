package com.example.imdbapp.presentation.moviedetails

import android.util.Log
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
    val movieDetailsState = viewModel.movieState.value
    val actorLazyRowState = viewModel.actorsLazyRowState.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(50.dp)
        ) {
            if (!movieDetailsState.isLoading && movieDetailsState.error == "") {
                Text(
                    text = movieDetailsState.movie?.title ?: "null",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 30.sp
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Row() {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(movieDetailsState.movie?.image?.url ?: "null")
                            .crossfade(true)
                            .build(),
                        modifier = Modifier.height(300.dp).width(200.dp)
                            .padding(start = 16.dp),
                        contentDescription = "movie image"
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Release year: ${movieDetailsState.movie?.year ?: "null"}",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "running time: ${movieDetailsState.movie?.runningTimeInMinutes ?: "null"} mins",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Movie rating: ${movieDetailsState.movie?.chartRating?.rating ?: "Unknown"}",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
                Text(
                    text = "Description : ${movieDetailsState.movie?.description?.text ?: "Not provided"}",
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                LazyRow(modifier = Modifier.height(175.dp)) {
                    items(movieDetailsState.movie?.principals?.size ?: 0) { i ->
                        if (!actorLazyRowState.isLoading && actorLazyRowState.error == "") {
                            Log.d("results lazyrowstate", "${actorLazyRowState.isLoading}")
                            MovieCastItem(
                                actorName = movieDetailsState.movie?.principals?.get(i)?.name
                                    ?: "null",
                                actorsCharacter = movieDetailsState.movie?.principals?.get(i)?.characters?.get(
                                    0
                                )
                                    ?: "null",
                                actorsImageUrl = actorLazyRowState.actors?.get(i) ?: "null",
                                modifier = Modifier.padding(16.dp).clickable { Unit }
                            )
                            if (i < (movieDetailsState.movie?.principals?.size ?: 0) - 1) {
                                Divider(
                                    modifier = Modifier.padding(vertical = 8.dp).width(2.dp)
                                        .fillParentMaxHeight()
                                )
                            }
                        } else {
                            Column(modifier = Modifier.padding(horizontal = 16.dp).width(200.dp)) {
                                Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                            .padding(top = 70.dp)
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = movieDetailsState.message,
                                        color = Color.Red,
                                        fontSize = 20.sp
                                    )
                                }
                                Text(
                                    text = movieDetailsState.error,
                                    color = MaterialTheme.colors.error,
                                    fontSize = 20.sp
                                )
                            }

                            if (i < (movieDetailsState.movie?.principals?.size ?: 0) - 1) {
                                Divider(
                                    modifier = Modifier.padding(vertical = 8.dp).width(2.dp)
                                        .fillParentMaxHeight()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (movieDetailsState.isLoading) {
            Column() {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = movieDetailsState.message,
                    color = Color.Red,
                    fontSize = 20.sp
                )
            }
        } else if (movieDetailsState.error != "") {
            Text(
                text = movieDetailsState.error,
                color = MaterialTheme.colors.error,
                fontSize = 20.sp
            )
        }
    }
}
