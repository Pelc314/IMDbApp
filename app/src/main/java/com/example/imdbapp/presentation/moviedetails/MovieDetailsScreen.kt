package com.example.imdbapp.presentation.moviedetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun MovieDetailsScreen(
    movieId: String,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Text(text = state?.movieDetails?.title ?: "null")
}
