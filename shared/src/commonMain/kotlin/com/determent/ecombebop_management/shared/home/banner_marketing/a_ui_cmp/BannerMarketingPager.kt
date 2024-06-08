package com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.determent.ecombebop_management.shared.home.banner_marketing.a_model.BMRelationMappingContent
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content.BMRelationMappingContent

/**
 * [contentZero] - the very first component that is responsible for the operations of adding content.
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerMarketingPager(
    images: List<BMRelationMappingContent>,
    contentManagement: @Composable () -> Unit,
    relationMappingContent: @Composable (index: Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    val pagerState = rememberPagerState {
        images.size
    }

    HorizontalPager(
        state = pagerState,
        key = {
            images[it]
        }
    ) { index ->
        if (index == 0) {
            contentManagement()
        } else {
            relationMappingContent(index)
        }
    }
}