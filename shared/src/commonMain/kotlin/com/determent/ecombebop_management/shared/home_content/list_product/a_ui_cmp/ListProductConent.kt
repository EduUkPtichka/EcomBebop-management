package com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.decompose.ListProductComponent

@Composable
fun ListProductContent(
    component: ListProductComponent,
    modifier: Modifier = Modifier,
) {

    val model by component.model.collectAsState()

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalPagerGrid(
            items = model.listProduct,
            onClickAddProduct = component::onClickedAddProduct,
            modifier = Modifier
        )
    }
}