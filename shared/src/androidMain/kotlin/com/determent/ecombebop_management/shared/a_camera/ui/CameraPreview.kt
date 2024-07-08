package com.determent.ecombebop_management.shared.a_camera.ui

import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.determent.ecombebop_management.shared.my_material.MyColumnCenter

@Composable
fun CameraPreview(
    lifecycleCameraController: LifecycleCameraController,
    modifier: Modifier = Modifier,
) {

    MyColumnCenter(modifier = modifier) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                previewView.controller = lifecycleCameraController

                previewView
            }

        )
    }

}