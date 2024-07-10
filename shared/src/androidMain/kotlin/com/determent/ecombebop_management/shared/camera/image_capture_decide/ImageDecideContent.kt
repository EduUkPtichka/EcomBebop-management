package com.determent.ecombebop_management.shared.camera.image_capture_decide

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ImageDecideContent(
    component: ImageDecideComponent
) {

    Scaffold(
        modifier = Modifier.background(Color.Red).fillMaxSize(),
        topBar = {
            ImageDecideTopBar()
        },
        bottomBar = {
            ImageDecideBottomBar()
        }
    ) { innerPadding ->
        Image(
            bitmap = component.model,
            contentDescription = null,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
private fun ImageDecideTopBar() {

}

@Composable
private fun ImageDecideBottomBar() {

}