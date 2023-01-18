package com.example.imdbapp.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination(start = true)
fun TopRatedMoviesScreen(
    viewModel: TopRatedMoviesViewModel = hiltViewModel()
) {
    println("pkacki")
    val state = viewModel.state
}
