package com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.determent.ecombebop_management.shared.home_content.list_product.domain.decompose.ListProductComponent
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun CardItemProduct(
    onClick: () -> Unit,
    itemProduct: ListProductComponent.ProductItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            //.clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .height(300.dp)
            .fillMaxWidth(),
    ) {

        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Black)
                .border(
                    width = Dp.Hairline,
                    color = colorResource(MR.colors.black),
                    shape = RoundedCornerShape(8.dp)
                )
                .weight(0.9f)
                .fillMaxWidth(),
            backgroundColor = Color.Black,
            shape = RoundedCornerShape(8.dp)
        ) {
            AsyncImage(
                model = itemProduct.mainImage,
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .weight(0.1f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                TextTitle(text = itemProduct.title)
                TextBrand(text = itemProduct.brand)
            }
        }

    }
}

@Composable
private fun TextTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth().padding(start = 5.dp),
        color = Color.Black
    )
}

@Composable
private fun TextBrand(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth().padding(start = 5.dp),
        color = Color.Black
    )
}