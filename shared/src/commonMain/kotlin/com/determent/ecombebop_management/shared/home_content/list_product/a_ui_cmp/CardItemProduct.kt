package com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model.ProductItem
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun CardItemProduct(
    onClick: () -> Unit,
    itemProduct: ProductItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            //.clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .height(360.dp)
            .fillMaxWidth(),
    ) {

        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .border(width = Dp.Hairline, color = colorResource(MR.colors.black), shape = RoundedCornerShape(8.dp))
                .weight(6.0f)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                AsyncImage(
                    model = itemProduct.mainImage,
                    contentDescription = null
                )

                if (itemProduct.discount > 0) {
                    DiscountImageText(
                        discount = itemProduct.discount,
                        modifier = Modifier.align(Alignment.BottomStart)
                    )
                }

            }
        }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .weight(1.4f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (itemProduct.discount == 0 || itemProduct.priceCalculated == 0) {
                    TextPrice(prise = itemProduct.price)
                } else {
                    TextPrisePlusCalculatePrice(prise = itemProduct.price, priceCalculated = itemProduct.priceCalculated)
                }
            }

            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextTitle(text = itemProduct.title)
                TextBrand(text = itemProduct.brand)
            }
        }
    }
}

@Composable
private fun DiscountImageText(discount: Int, modifier: Modifier) {
    val transformation = "–${discount}%"
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(topEnd = 6.dp))
            .background(Color.Red)
            .wrapContentSize()
            .height(18.dp)
            .width(38.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = transformation,
            color = Color.White,
            fontSize = 11.sp,
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
private fun TextPrice(prise: Int, modifier: Modifier = Modifier) {
    Text(
        text = prise.toString(),
        modifier = Modifier.padding(start = 4.dp),
        color = Color.Black,
        fontSize = 13.sp,
        style = MaterialTheme.typography.button
    )
    Spacer(Modifier.width(2.dp))
    Text(
        text = "сом",
        modifier = Modifier.padding(start = 4.dp),
        color = Color.Black,
        style = MaterialTheme.typography.button
    )
}

@Composable
private fun TextPrisePlusCalculatePrice(prise: Int, priceCalculated: Int) {
    Text(
        text = priceCalculated.toString(),
        modifier = Modifier.padding(start = 4.dp),
        color = Color.Black,
        textDecoration = TextDecoration.LineThrough,
        style = MaterialTheme.typography.overline
    )
    Spacer(Modifier.width(2.dp))
    Text(
        text = prise.toString(),
        modifier = Modifier.padding(start = 4.dp),
        color = Color.Red,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.button
    )
    Spacer(Modifier.width(1.dp))
    Text(
        text = "сом",
        modifier = Modifier.padding(start = 4.dp),
        color = Color.Black,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.button
    )

}

@Composable
private fun TextTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth().padding(start = 4.dp),
        color = Color.Black,
        style = MaterialTheme.typography.caption
    )
}

@Composable
private fun TextBrand(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth().padding(start = 4.dp),
        color = Color.Black,
        style = MaterialTheme.typography.caption
    )
}