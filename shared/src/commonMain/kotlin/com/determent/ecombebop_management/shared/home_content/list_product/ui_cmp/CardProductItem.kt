package com.determent.ecombebop_management.shared.home_content.list_product.ui_cmp

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.determent.ecombebop_management.shared.home_content.list_product.model.ProductItemModel
import com.determent.ecombebop_management.shared.my_resource.MyTypography.SfProDisplayRegular
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun CardProductItem(
    onClick: () -> Unit,
    itemProduct: ProductItemModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .background(colorResource(MR.colors.white))
            .fillMaxWidth()
            .height(310.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            shape = RoundedCornerShape(8.dp),
            backgroundColor = colorResource(MR.colors.gray500)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                AsyncImage(
                    model = itemProduct.mainImage,
                    contentDescription = null
                )

                if (itemProduct.discount > 0) {
                    DiscountImage(
                        discount = itemProduct.discount,
                        modifier = Modifier.align(Alignment.BottomStart)
                    )
                }

            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                if (itemProduct.discount == 0 || itemProduct.priceCalculated == 0) {
                    TextPrice(prise = itemProduct.price)
                } else {
                    TextPrisePlusCalculatePrice(prise = itemProduct.price, priceCalculated = itemProduct.priceCalculated)
                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 8.dp, top = 4.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                TextTitle(text = itemProduct.title)
                TextBrand(text = itemProduct.brand)
            }
        }
    }
}

@Composable
private fun DiscountImage(discount: Int, modifier: Modifier) {
    val transformation = "-${discount}%" // –

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(topEnd = 8.dp))
            .background(colorResource(MR.colors.red200))
            .wrapContentSize()
            .width(36.dp)
            .height(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = transformation,
            modifier = Modifier,
            color = colorResource(MR.colors.white),
            fontSize = 12.sp,
            fontFamily = SfProDisplayRegular()
        )
    }
}

@Composable
private fun TextPrice(prise: Int, modifier: Modifier = Modifier) {
    Text(
        text = prise.toString(),
        color = colorResource(MR.colors.black),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = SfProDisplayRegular(),
    )
    Spacer(Modifier.width(2.dp))
    Text(
        text = "с",
        color = colorResource(MR.colors.black),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = SfProDisplayRegular()
    )
}

@Composable
private fun TextPrisePlusCalculatePrice(prise: Int, priceCalculated: Int) {
    Text(
        text = priceCalculated.toString(),
        modifier = Modifier,
        color = colorResource(MR.colors.black),
        fontSize = 12.sp,
        fontFamily = SfProDisplayRegular(),
        textDecoration = TextDecoration.LineThrough,
    )
    Spacer(Modifier.width(4.dp))
    Text(
        text = prise.toString(),
        color = colorResource(MR.colors.red200),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = SfProDisplayRegular(),
    )
    Spacer(Modifier.width(2.dp))
    Text(
        text = "с",
        modifier = Modifier,
        color = colorResource(MR.colors.red200),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = SfProDisplayRegular()
    )

}

@Composable
private fun TextTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = colorResource(MR.colors.black),
        fontSize = 14.sp,
        fontFamily = SfProDisplayRegular()
    )
}

@Composable
private fun TextBrand(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = colorResource(MR.colors.black),
        fontSize = 14.sp,
        fontFamily = SfProDisplayRegular()
    )
}