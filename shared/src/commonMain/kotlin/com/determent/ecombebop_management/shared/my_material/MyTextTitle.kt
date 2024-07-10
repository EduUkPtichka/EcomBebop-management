package com.determent.ecombebop_management.shared.my_material

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import com.determent.ecombebop_management.shared.my_resource.MyTypography.SfProDisplayRegular
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun MyTextTitle(
    text: String,
    color: Color = colorResource(MR.colors.black),
    fondSize: TextUnit,
    modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fondSize,
        fontFamily = SfProDisplayRegular()
    )
}
