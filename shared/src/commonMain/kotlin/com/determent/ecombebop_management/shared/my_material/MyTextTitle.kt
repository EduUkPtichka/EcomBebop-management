package com.determent.ecombebop_management.shared.my_material

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import com.determent.ecombebop_management.shared.my_resource.MyTypography.SfProDisplayRegular
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun MyTextTitle(text: String, fondSize: TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = colorResource(MR.colors.black),
        fontSize = fondSize,
        fontFamily = SfProDisplayRegular()
    )
}
