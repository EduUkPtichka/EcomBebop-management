package com.determent.ecombebop_management.shared.camera.camera_take_picture.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.determent.ecombebop_management.shared.my_material.MyTextTitle
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import org.example.library.MR

@Composable
fun CameraBottomBar(
    onTakePicture: () -> Unit,
    onClickBackNav: () -> Unit,
) {

    Box(
        modifier = Modifier
            .background(colorResource(MR.colors.black))
            .fillMaxWidth()
            .height(154.dp),
        contentAlignment = Alignment.Center
    ) {

        CameraBackNav(
            onClick = { onClickBackNav() },
            modifier = Modifier
                .padding(start = 16.dp, top = 44.dp)
                .align(Alignment.TopStart)
        )

        CameraButton(
            onClick = { onTakePicture() },
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.TopCenter)
        )

    }
}

@Composable
private fun CameraBackNav(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = { onClick() },
        modifier = modifier
    ) {
        MyTextTitle(
            text = stringResource(MR.strings.camera_back_nav),
            color = colorResource(MR.colors.white),
            fondSize = 16.sp,
        )
    }
}

@Composable
private fun CameraButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Icon(
            painterResource(MR.images.svg_camera_buttom),
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = colorResource(MR.colors.white)
        )
    }
}
