package com.determent.ecombebop_management.shared.home_content.list_product.ui_cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.determent.ecombebop_management.shared.home_content.list_product.model.ProductItemModel
import com.determent.ecombebop_management.shared.my_resource.MyTypography.SfProDisplayRegular
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.stringResource
import org.example.library.MR

@Composable
fun VerticalPagerGrid(
    items: List<ProductItemModel>,
    onClickAddProduct: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(MR.colors.white)),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {

        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            InfoForManager()
        }

        items(1) {
            CardAddProduct(onClick = { onClickAddProduct() })
        }

        itemsIndexed(items) { index, item ->
            CardProductItem(
                onClick = { },
                itemProduct = item
            )
        }

    }

}

@Composable
private fun InfoForManager(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(MR.strings.manager_add_list_relation),
            modifier = Modifier.padding(bottom = 16.dp),
            color = colorResource(MR.colors.black),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = SfProDisplayRegular()
        )
    }
}
