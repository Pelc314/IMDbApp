package com.example.imdbapp.presentation.moviedetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun MovieDetailsScreen(
    query: String,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value.movieDetails

    Text(text = state?.title ?: "null")
}
