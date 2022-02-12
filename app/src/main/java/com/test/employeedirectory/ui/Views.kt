package com.test.employeedirectory.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.test.employeedirectory.R

/**
 * Full screen circular progress indicator
 */
@Composable
fun FullScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun NetworkImageView(
    imageUrl: String,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.None,
    modifier: Modifier = Modifier,
    builder: ImageRequest.Builder.() -> Unit = {
        placeholder(R.drawable.placeholder)
        error(R.drawable.error_image_generic)
    }
) {
    Image(
        painter = rememberImagePainter(
            data = imageUrl,
            onExecute = ImagePainter.ExecuteCallback { _, _ -> true },
            builder = builder
        ),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}