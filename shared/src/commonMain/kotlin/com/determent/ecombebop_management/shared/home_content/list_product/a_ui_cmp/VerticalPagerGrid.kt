package com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home_content.list_product.domain.model.CardItemModel

@Composable
fun VerticalPagerGrid(
    items: List<*>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        itemsIndexed(items) { index, item ->
            if (index == 0) {
                CardAddProduct(onClick = {})
            } else {
                CardProduct(
                    onClick = {}
                )
            }
        }
    }
}
