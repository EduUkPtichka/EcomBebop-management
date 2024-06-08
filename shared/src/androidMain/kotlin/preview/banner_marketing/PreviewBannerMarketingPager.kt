package preview.banner_marketing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.determent.ecombebop_management.shared.home.banner_marketing.a_model.BMRelationMappingContent
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.BannerMarketingPager
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content.BMContentManagement
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content.BMRelationMappingContent
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

@Preview
@Composable
private fun PreviewBannerMarketingPager() {

    val images by remember {
        mutableStateOf(
            listOf(
                BMRelationMappingContent(
                    ""
                ),
                BMRelationMappingContent(
                    "https://batnorton.com/img/about4.webp"
                ),
            )
        )
    }

    BannerMarketingPager(
        images = images,
        contentManagement = {
            BMContentManagement(
                onClick = { },
                icon = painterResource(imageResource = MR.images.svg_plus)
            )
        },
        relationMappingContent = {
            BMRelationMappingContent(
                onClick = {},
                imageUrl = images[it]
            )
        }

    )
}