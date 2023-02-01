package com.example.imdbapp.presentation.mainscreenwithtopmovies

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imdbapp.presentation.destinations.MovieDetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun TopRatedMoviesScreen(
    navigator: DestinationsNavigator,
    viewModel: TopRatedMoviesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = state.searchQuery,
                onValueChange = { viewModel.updateState(it) },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                placeholder = { Text(text = "Search...") },
                maxLines = 1,
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    navigator.navigate(
                        MovieDetailsScreenDestination(state.searchQuery)
                    )
                })
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.topRatedMovies.size) { i ->
                    val movie = state.topRatedMovies[i]
                    MovieItem(
                        movie = movie,
                        modifier = Modifier.fillMaxWidth().clickable {
                            navigator.navigate(
                                MovieDetailsScreenDestination(movie.id ?: "")

                            )
                        }.padding(16.dp)
                    )
                    if (i < state.topRatedMovies.size) {
                        Divider(modifier = Modifier.padding(horizontal = 16.dp))
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
                    color = MaterialTheme.colors.error
                )
            }
        }
    }
}
