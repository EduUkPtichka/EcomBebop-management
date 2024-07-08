package com.determent.ecombebop_management.shared.a_camera.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.determent.ecombebop_management.shared.my_material.MyTextTitle
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

@Composable
fun CameraBottomBar(
    takePicture: () -> Unit,
    onBackClicked: () -> Unit,
    ucePhoto: () -> Unit,
    modifier: Modifier = Modifier
) {

    /**
     * the state changes in the BottomDecide
     */
    var isBottomWhich: Boolean by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        if (isBottomWhich) {
            BottomForTakePicture(
                takePicture = { takePicture() },
                onBackClicked = { onBackClicked() },
            )
        } else {
            BottomDecide(
                againTakePicture = {
                    isBottomWhich = true
                },
                ucePhoto = {
                    ucePhoto()
                },
            )
        }
    }
}

@Composable
private fun BottomForTakePicture(
    takePicture: () -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(colorResource(MR.colors.black))
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        TextButton(
            onClick = { onBackClicked() },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            MyTextTitle(
                text = "Назад", fondSize = 12.sp
            )
        }

        IconButton(
            onClick = { takePicture() },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                painter = painterResource(MR.images.svg_camera_clicker),
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                tint = colorResource(MR.colors.white)
            )
        }
    }
}

@Composable
private fun BottomDecide(
    againTakePicture: () -> Unit,
    ucePhoto: () -> Unit,
) {

}