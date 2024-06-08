package com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.determent.ecombebop_management.shared.home.banner_marketing.a_model.BMRelationMappingContent

@Composable
fun BMRelationMappingContent(
    onClick: () -> Unit,
    imageUrl: BMRelationMappingContent,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}