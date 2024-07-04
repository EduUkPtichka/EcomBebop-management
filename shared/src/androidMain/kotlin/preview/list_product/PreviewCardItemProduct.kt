package preview.list_product

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model.ProductItemModel
import com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp.CardProductItem

@Preview
@Composable
private fun PreviewCardItemProduct() {


    val item = ProductItemModel(
        mainImage = 1,
        price = 11000,
        discount = 96,
        priceCalculated = 5400,
        title = "String",
        brand = "Brend"
    )

    Box(modifier = Modifier.width(168.dp).height(310.dp) ){
        CardProductItem(onClick = { }, itemProduct = item)
    }

}