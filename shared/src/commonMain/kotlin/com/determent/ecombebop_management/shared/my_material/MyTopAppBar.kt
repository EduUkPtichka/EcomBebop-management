package com.determent.ecombebop_management.shared.my_material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import org.example.library.MR

@Composable
fun MyTopAppBar(
    onClick: () -> Unit
) {

    TopAppBar(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 10.dp, topStart = 10.dp))
            .fillMaxWidth()
            .height(44.dp),
        backgroundColor = colorResource(MR.colors.white),
        elevation = 2.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        Box {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon({})
            }

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyTextTitle(text = stringResource(MR.strings.manager_add_product_title), fondSize = 16.sp)
            }
        }

    }
}

@Composable
private fun Icon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        painterResource(MR.images.svg_arrow_back),
        contentDescription = null,
        modifier = Modifier,
        tint = colorResource(MR.colors.black)
    )
}