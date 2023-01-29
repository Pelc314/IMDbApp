package com.example.imdbapp.presentation.mainscreenwithtopmovies

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination(start = true)
fun TopRatedMoviesScreen(
    viewModel: TopRatedMoviesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.topRatedMovies.size) { i ->
                val movie = state.topRatedMovies[i]
                MovieItem(
                    movie = movie
//                    modifier = Modifier.fillMaxWidth().clickable {
//                    navigator.navigate(
//                        CompanyInfoScreenDestination(company.symbol)
//                    )
//                    }.padding(16.dp)
                )
                if (i < state.topRatedMovies.size) {
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
