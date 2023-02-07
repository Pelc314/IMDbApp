package com.example.imdbapp.presentation.actordetails

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun ActorDetailsScreen(
    actorId: String,
    viewModel: ActorDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        if (!state.isLoading && state.error == "") {
            Column() {
                Text(
                    text = state.actor?.name ?: "Error",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Row() {
                    AsyncImage(
                        model = state.actor?.image?.url ?: "null",
                        contentDescription = "Actor's image",
                        modifier = Modifier
                            .height(300.dp)
                            .width(200.dp)
                            .padding(start = 16.dp)
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Birth date: ${state.actor?.birthDate ?: "Unknown"}",
                            modifier = Modifier.padding(bottom = 16.dp, top = 10.dp)
                        )
                        Text(
                            text = "Birth place: ${state.actor?.birthPlace ?: "Unknown"}",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Height: ${state.actor?.heightCentimeters ?: "Unknown"} cm",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Real name: ${state.actor?.realName ?: "Unknown"}",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        if (!((state.actor?.nicknames?.get(0).isNullOrBlank() ?: 0) as Boolean)) {
                            Text(
                                text = "Nicknames: ",
                                modifier = Modifier
                            )
                            LazyColumn() {
                                items(state.actor?.nicknames?.size ?: 0) { i ->
                                    Text(text = state.actor?.nicknames?.get(i) ?: "Unknown")
                                }
                            }
                        }
                    }
                }
                Text(
                    text = "About ${state.actor?.name}: ",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = state.actor?.miniBios?.get(0)?.text ?: "Unknown",
                    modifier = Modifier
                        .height(150.dp)
                        .verticalScroll(rememberScrollState(0))
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Text(
                    text = "Characteristics: ",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                LazyColumn(
                    modifier = Modifier
                        .height(150.dp)
                        .padding(16.dp)
                ) {
                    items(state.actor?.trademarks?.size ?: 0) { i ->
                        Text(text = state.actor?.trademarks?.get(i) ?: "Unknown")
                    }
                }
                Text(
                    text = "Known for: ",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                LazyColumn(
                    modifier = Modifier
                        .height(150.dp)
                        .padding(16.dp)
                ) {
                    items(state.actor?.knownFor?.size ?: 0) { i ->
                        Text(text = state.actor?.knownFor?.get(i)?.id ?: "Unknown")
                    }
                }
            }
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
