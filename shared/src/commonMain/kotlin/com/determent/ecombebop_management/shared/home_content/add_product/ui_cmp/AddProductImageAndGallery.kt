package com.determent.ecombebop_management.shared.home_content.add_product.ui_cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

@Composable
fun AddProductImageAndGallery() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp + 32.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(MR.colors.white)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(MR.colors.gray500))
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(colorResource(MR.colors.gray300))
                        .size(50.dp),
                    contentAlignment = Alignment.Center
                ) {
//                    Icon(
//                        painterResource(MR.images.svg_camera),
//                        contentDescription = null,
//                        modifier = Modifier.size(28.dp),
//                        tint = colorResource(MR.colors.white)
//                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(colorResource(MR.colors.gray300))
                        .size(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painterResource(MR.images.svg_gallery),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = colorResource(MR.colors.white)
                    )
                }
            }
        }

    }
}

