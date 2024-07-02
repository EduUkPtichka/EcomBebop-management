package com.determent.ecombebop_management.shared.a_cmp_ui_material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun LabelEditText() {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(colorResource(MR.colors.gray500))
    ) {
        BasicTextField(
            value = "eeee",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
    }

}