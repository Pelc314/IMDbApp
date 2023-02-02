package com.example.imdbapp.presentation.actordetails

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun ActorDetailsScreen(
    actorId: String,
    viewModel: ActorDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Text(text = state?.actor?.name ?: "null")
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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
