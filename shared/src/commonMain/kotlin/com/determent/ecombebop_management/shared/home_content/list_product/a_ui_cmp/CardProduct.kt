package com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun CardProduct(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .height(300.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = Dp.Hairline,
                color = colorResource(MR.colors.black),
                shape = RoundedCornerShape(8.dp)
            ),
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(8.dp)
        ) {

        }

        Box(

        ) {
            Text("Здесь будет текст")
        }
    }
}