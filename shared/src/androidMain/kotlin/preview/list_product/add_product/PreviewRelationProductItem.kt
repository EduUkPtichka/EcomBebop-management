package preview.list_product.add_product

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.domain.model.AddProductItemModel
import com.determent.ecombebop_management.shared.home_content.list_product.add_product.ui_cmp.RelationProductItem

@Preview
@Composable
fun PreviewRelationProductItem() {

    val a = AddProductItemModel(
        mainImage = 0,
        price = 17000,
        discount = 33,
        priceCalculated = 11,
        title = "Платье",
        brand = "badNordon"
    )

    RelationProductItem(itemProduct = a)
}