package com.example.imdbapp.presentation.mainscreenwithtopmovies

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imdbapp.presentation.destinations.MovieDetailsScreenDestination
import com.example.imdbapp.presentation.destinations.SearchResultsScreenDestination
import com.example.imdbapp.presentation.mainscreenwithtopmovies.components.MovieItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun TopRatedMoviesScreen(
    navigator: DestinationsNavigator,
    viewModel: TopRatedMoviesViewModel = hiltViewModel(),
) {
    val moviesListState = viewModel.topRatedMoviesListState.value
    val movieState = viewModel.topRatedMovieState

    Box(modifier = Modifier.fillMaxSize()) {
        if (!moviesListState.isLoading && moviesListState.error == "") {
            Column(modifier = Modifier.fillMaxSize()) {
                OutlinedTextField(
                    value = moviesListState.searchQuery,
                    onValueChange = { viewModel.updateState(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    placeholder = { Text(text = "Search...") },
                    maxLines = 1,
                    singleLine = true,
                    keyboardActions = KeyboardActions(onDone = {
                        navigator.navigate(
                            SearchResultsScreenDestination(moviesListState.searchQuery),
                        )
                    }),
                )
                Text(
                    text = "Top Rated Movies",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Log.d("FetchedMovieScreenSize", "${moviesListState.topRatedMovies.size}")
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(moviesListState.topRatedMovies.size) { i ->
                        val movie = moviesListState.topRatedMovies[i]
                        viewModel.getTopRatedMovie(movie.id ?: "null", i)
                        Log.d(
                            "FetchedMovieData",
                            "${movie.id},${movie.title},${movieState[i].value.topRatedMovieItem?.title},${movieState[i].value.topRatedMovieItem?.id},$i,${movieState.size}",
                        )
                        MovieItem(
                            movieItemState = movieState[i].value,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navigator.navigate(
                                        MovieDetailsScreenDestination(
                                            movieState[i].value.topRatedMovieItem?.id ?: "",
                                        ),
                                    )
                                }
                                .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                        )
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (moviesListState.isLoading) {
                Column() {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = moviesListState.message,
                        color = Color.Red,
                        fontSize = 20.sp,
                    )
                }
            } else if (moviesListState.error != "") {
                Text(
                    text = moviesListState.error,
                    color = MaterialTheme.colors.error,
                    fontSize = 20.sp,
                )
            }
        }
    }
}
