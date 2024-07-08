package preview.list_product.add_product

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home_content.add_product.model.ProductItemRelationItemModel
import com.determent.ecombebop_management.shared.home_content.add_product.ui_cmp.CardProductItemRelation

@Preview
@Composable
private fun PreviewCardProductItemRelation() {

    val item = ProductItemRelationItemModel(
        mainImage = 1,
        price = 11000,
        discount = 96,
        priceCalculated = 5400,
        title = "String",
        brand = "Brend"
    )

    Box(
        modifier = Modifier
            .width(168.dp)
            .height(310.dp)
    ) {
        CardProductItemRelation(
            itemProduct = item,
            onClick = {}
        )
    }
}