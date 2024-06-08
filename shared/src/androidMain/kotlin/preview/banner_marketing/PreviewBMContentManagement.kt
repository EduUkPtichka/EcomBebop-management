package preview.banner_marketing

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content.BMContentManagement
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

@Preview
@Composable
private fun PreviewBMContentManagement() {
    BMContentManagement(
        onClick = { },
        icon = painterResource(imageResource = MR.images.svg_plus)
    )
}