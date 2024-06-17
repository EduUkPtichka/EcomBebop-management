package preview.list_product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp.VerticalPagerGrid

@Preview
@Composable
fun PreviewVerticalPagerGrid() {

    val items = listOf("", "", "", "")

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        VerticalPagerGrid(items = items)
    }

}