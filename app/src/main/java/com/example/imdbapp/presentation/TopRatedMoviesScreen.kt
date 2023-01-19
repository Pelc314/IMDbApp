package com.example.imdbapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination(start = true)
fun TopRatedMoviesScreen(
    viewModel: TopRatedMoviesViewModel = hiltViewModel()
) {
    val state = viewModel.state
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.topRatedMovies.size) { i ->
            val movie = state.topRatedMovies[i]
            MovieItem(
                movie = movie,
                modifier = Modifier.fillMaxWidth().clickable {
//                    navigator.navigate(
//                        CompanyInfoScreenDestination(company.symbol)
//                    )
                }.padding(16.dp)
            )
            if (i < state.topRatedMovies.size) {
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}
