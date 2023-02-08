package com.example.imdbapp.presentation.SearchResults.components

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.imdbapp.domain.model.searchresults.SearchResultsDetails

@Composable
fun SearchResultItem(
    results: SearchResultsDetails,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(modifier = Modifier.width(250.dp)) {
                val resultId = results.id ?: ""
                val actorOrMovie = resultId[0] == 'n'
                if (!actorOrMovie) {
                    Text(
                        text = results.title ?: "null",
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    if (results.runningTimeInMinutes == 0) {
                        Text(text = "Movie length: Unknown")
                    } else Text(
                        text = "Movie length: ${results.runningTimeInMinutes} min"
                    )
                } else {
                    Text(
                        text = results.name ?: "null",
                        color = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Column(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = results.image?.url ?: "null",
                    contentDescription = "movie thumbnail",
                    modifier = Modifier
                        .size(
                            width = 90.dp,
                            height = 110.dp
                        )
                        .align(Alignment.End)
                )
            }
        }
    }
}
