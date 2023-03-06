package com.example.imdbapp.presentation.SearchResults.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.imdbapp.core.util.CustomAsyncImage
import com.example.imdbapp.domain.model.searchresults.SearchResultsDetails

@Composable
fun SearchResultItem(
    results: SearchResultsDetails,
    modifier: Modifier = Modifier,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = modifier.background(
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp),
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Column(modifier = Modifier.width(250.dp)) {
                val resultId = results.id ?: ""
                val actorOrMovie = resultId[0] == 'n'
                if (!actorOrMovie) {
                    if (results.titleType == "movie") {
                        Text(
                            text = "Movie",
                            color = MaterialTheme.colors.onBackground,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 10.dp),
                        )
                    } else if (results.titleType == "tvSeries") {
                        Text(
                            text = "Series",
                            color = MaterialTheme.colors.onBackground,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 10.dp),
                        )
                    } else {
                        val type = (
                            results.titleType?.first()?.uppercase()
                                ?: ""
                            ) + (results.titleType?.drop(1) ?: "")
                        Text(
                            text = type,
                            color = MaterialTheme.colors.onBackground,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 10.dp),

                        )
                    }
                    Text(
                        text = results.title ?: "null",
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 10.dp),

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    if (results.runningTimeInMinutes == 0) {
                        Text(
                            text = "Movie length: Unknown",
                            modifier = Modifier.padding(start = 10.dp),
                        )
                    } else {
                        Text(
                            text = "Movie length: ${results.runningTimeInMinutes} min",
                            modifier = Modifier.padding(start = 10.dp),

                        )
                    }
                } else {
                    Text(
                        text = "Actor",
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp),

                    )
                    Text(
                        text = results.name ?: "null",
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 10.dp),

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Column(modifier = Modifier.fillMaxSize()) {
                CustomAsyncImage(
                    url = results.image?.url ?: "null",
                    modifier = Modifier
                        .size(
                            width = 90.dp,
                            height = 110.dp,
                        )
                        .align(Alignment.End),
                    crop = ContentScale.Crop,
                )
            }
        }
    }
}
