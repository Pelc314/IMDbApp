package com.example.imdbapp.presentation.actordetails

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imdbapp.core.util.CustomAsyncImage
import com.example.imdbapp.presentation.actordetails.components.KnownForItem
import com.example.imdbapp.presentation.destinations.MovieDetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun ActorDetailsScreen(
    navigator: DestinationsNavigator,
    actorId: String,
    viewModel: ActorDetailsViewModel = hiltViewModel(),
) {
    val actorState = viewModel.actorState.value
    val knownForState = viewModel.knownForState.value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        if (!actorState.isLoading && actorState.error == "") {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState(0)),
            ) {
                Text(
                    text = actorState.actor?.name ?: "Error",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Row() {
                    CustomAsyncImage(
                        url = actorState.actor?.image?.url ?: "null",
                        modifier = Modifier
                            .height(300.dp)
                            .width(200.dp)
                            .padding(start = 16.dp, bottom = 16.dp, top = 16.dp),
                        roundedCorner = 20.dp,
                        ContentScale.Crop,
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Birth date: ${actorState.actor?.birthDate ?: "Unknown"}",
                            modifier = Modifier.padding(bottom = 16.dp, top = 10.dp),
                        )
                        if (actorState.actor?.deathDate != null) {
                            Text(
                                text = "Death date: ${actorState.actor.deathDate ?: "Unknown"}",
                                modifier = Modifier.padding(bottom = 16.dp),
                            )
                        }
                        if ((actorState.actor?.birthPlace?.isNullOrBlank() ?: true)) {
                            Text(
                                text = "Birth place: ${actorState.actor?.birthPlace ?: "Unknown"}",
                                modifier = Modifier.padding(bottom = 16.dp),
                            )
                        }
                        if (actorState.actor?.heightCentimeters != 0.0) {
                            Text(
                                text = "Height: ${actorState.actor?.heightCentimeters ?: "Unknown"} cm",
                                modifier = Modifier.padding(bottom = 16.dp),
                            )
                        }
                        if (!actorState.actor?.nicknames?.get(0).isNullOrBlank()) {
                            Text(
                                text = "Nickname: ",
                                modifier = Modifier,
                            )
                            Text(text = actorState.actor?.nicknames?.get(0) ?: "Unknown")
                        }
                    }
                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Text(
                    text = "About ${actorState.actor?.name}: ",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = actorState.actor?.miniBios?.get(0)?.text ?: "Unknown",
                    modifier = Modifier
                        .height(150.dp)
                        .verticalScroll(rememberScrollState(0))
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                )
                if (!actorState.actor?.trademarks?.get(0).isNullOrBlank()) {
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                    Text(
                        text = "Characteristics: ",
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    var height: Dp
                    when (actorState.actor?.trademarks?.size) {
                        1 -> height = 70.dp
                        2 -> height = 90.dp
                        3 -> height = 110.dp
                        4 -> height = 140.dp
                        else -> height = 200.dp
                    }
                    LazyColumn(
                        modifier = Modifier
                            .height(height = height)
                            .padding(16.dp),
                    ) {
                        items(actorState.actor?.trademarks?.size ?: 0) { i ->
                            Text(text = actorState.actor?.trademarks?.get(i) ?: "Unknown")
                        }
                    }
                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Text(
                    text = "Known for: ",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                LazyColumn(
                    modifier = Modifier
                        .height(600.dp)
                        .padding(16.dp),
                ) {
                    Log.d("itemCount", "${actorState.actor?.knownFor?.size ?: 0}")
                    var itemCount = 5
                    if (!knownForState.isLoading) itemCount = knownForState.knownFor?.size ?: 0
                    items(itemCount) { i ->
                        if (!knownForState.isLoading) {
                            if (((knownForState.knownFor?.isEmpty() ?: 0) as Boolean)) {
                                Text(
                                    text = "Didn't play in any popular movie",
                                    modifier = Modifier.padding(16.dp),
                                )
                            } else {
                                knownForState.knownFor?.let {
                                    KnownForItem(
                                        knownFor = it.get(i),
                                        modifier = Modifier
                                            .height(150.dp)
                                            .width(400.dp)
                                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                                            .clickable {
                                                navigator.navigate(
                                                    MovieDetailsScreenDestination(
                                                        knownForState.knownFor[i].title?.id?.split(
                                                            '/',
                                                        )?.get(2) ?: "",
                                                    ),
                                                )
                                            },
                                    )
                                }
                            }
                        } else {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .width(200.dp).background(
                                        color = Color.LightGray,
                                        shape = RoundedCornerShape(16.dp),
                                    ),
                            ) {
                                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                                    CircularProgressIndicator(
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .padding(top = 70.dp),
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = knownForState.message,
                                        color = Color.Red,
                                        fontSize = 20.sp,
                                    )
                                }
                                Text(
                                    text = knownForState.error,
                                    color = MaterialTheme.colors.error,
                                    fontSize = 20.sp,
                                )
                                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (actorState.isLoading) {
                Column() {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = actorState.message,
                        color = Color.Red,
                        fontSize = 20.sp,
                    )
                }
            } else if (actorState.error != "") {
                Text(
                    text = actorState.error,
                    color = MaterialTheme.colors.error,
                )
            }
        }
    }
}
