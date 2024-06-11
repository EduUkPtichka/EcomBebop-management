package com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import coil3.compose.setSingletonImageLoaderFactory
import com.determent.ecombebop_management.shared.core_coil.getAsyncImageLoader

@OptIn(ExperimentalCoilApi::class)
@Composable
fun BMRelationMappingContent(
    onClick: () -> Unit,
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }

    Row(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}