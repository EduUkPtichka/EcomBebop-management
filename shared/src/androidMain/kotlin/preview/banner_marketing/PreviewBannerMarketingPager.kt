package preview.banner_marketing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home.banner_marketing.a_model.BMRelationMappingContentModel
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.BannerMarketingPager
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content.BMContentManagement
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

@Preview
@Composable
private fun PreviewBannerMarketingPager() {

    val images = listOf(
        BMRelationMappingContentModel(
            "https://batnorton.com/img/about4.webp"
        ),
        BMRelationMappingContentModel(
            "https://batnorton.com/img/about4.webp"
        ),
        BMRelationMappingContentModel(
            "https://batnorton.com/img/about4.webp"
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BannerMarketingPager(
            images = images,
            contentManagement = {
                BMContentManagement(
                    onClick = { },
                    icon = painterResource(imageResource = MR.images.svg_plus)
                )
            },
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()

        )
    }
}