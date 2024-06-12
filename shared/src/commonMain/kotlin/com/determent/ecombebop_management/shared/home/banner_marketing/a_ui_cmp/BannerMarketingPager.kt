package com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp


//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun BannerMarketingPager(
//    images: List<BMRelationMappingContentModel>,
//    contentManagement: @Composable () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//
//    val pagerState = rememberPagerState {
//        images.size
//    }
//
//    LazyRow(
//        modifier = modifier
//            .height(200.dp)
//            .fillMaxWidth(),
//        contentPadding = PaddingValues(horizontal = 12.dp),
//        horizontalArrangement = Arrangement.spacedBy(6.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        itemsIndexed(images) { index, image ->
//            if (index == 0) {
//                contentManagement()
//            } else {
//                BMRelationMappingContent(
//                    onClick = {},
//                    imageUrl = image.image
//                )
//            }
//        }
//    }
//}