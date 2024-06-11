package com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home.banner_marketing.a_model.BMRelationMappingContentModel
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content.BMRelationMappingContent


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerMarketingPager(
    images: List<BMRelationMappingContentModel>,
    contentManagement: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {

    val pagerState = rememberPagerState {
        images.size
    }

    LazyRow(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(images) { index, image ->
            if (index == 0) {
                contentManagement()
            } else {
                BMRelationMappingContent(
                    onClick = {},
                    imageUrl = image.image
                )
            }
        }
    }
}