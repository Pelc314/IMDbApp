package com.example.imdbapp.core.util

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.simpleimdbapp.R

@Composable
fun CustomAsyncImage(
    url: String = "",
    modifier: Modifier = Modifier,
    roundedCorner: Dp = 16.dp,
    crop: ContentScale = ContentScale.Inside,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = "Image",
        placeholder = painterResource(id = R.drawable.baseline_downloading_24),
        error = painterResource(id = R.drawable.baseline_image_not_supported_24),
        modifier = modifier.clip(RoundedCornerShape(roundedCorner)),
        contentScale = crop,
    )
}
