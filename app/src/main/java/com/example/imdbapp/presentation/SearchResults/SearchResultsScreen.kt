package com.example.imdbapp.presentation.SearchResults

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imdbapp.presentation.SearchResults.components.SearchResultItem
import com.example.imdbapp.presentation.destinations.ActorDetailsScreenDestination
import com.example.imdbapp.presentation.destinations.MovieDetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun SearchResultsScreen(
    navigator: DestinationsNavigator,
    results: String,
    viewModel: SearchResultsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().height(50.dp)) {
            if (!state.isLoading) {
                Text(
                    text = "Search Results: $results",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 30.sp,
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.searchResults.size) { i ->
                    val results = state.searchResults[i]
                    SearchResultItem(
                        results = results,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val resultId = results.id ?: ""
                                val actorOrMovie = resultId.get(0) == 'n'
                                if (actorOrMovie) {
                                    navigator.navigate(ActorDetailsScreenDestination(resultId))
                                } else {
                                    navigator.navigate(MovieDetailsScreenDestination(resultId))
                                }
                            }
                            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    )
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
                        fontSize = 20.sp,
                    )
                }
            } else if (state.error != "") {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                )
            }
        }
    }
}
