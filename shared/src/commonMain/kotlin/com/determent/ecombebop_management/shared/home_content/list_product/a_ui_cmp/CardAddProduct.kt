package com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

@Composable
fun CardAddProduct(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(300.dp)
            .fillMaxWidth()
            .border(
                width = Dp.Hairline,
                color = colorResource(MR.colors.black),
                shape = RoundedCornerShape(8.dp)
            )
        ,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(MR.images.svg_plus),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
            ,
            tint = colorResource(MR.colors.black).copy(alpha = 0.1f)
        )
    }
}