package com.determent.ecombebop_management.shared.camera.camera_screen.presenter_cmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.determent.ecombebop_management.shared.camera.camera_screen.CameraScreenComponent
import com.determent.ecombebop_management.shared.camera.camera_take_picture.presenter.CameraTakePhotoContent

@Composable
actual fun CameraScreenContent(
    component: CameraScreenComponent
) {

    Children(
        stack = component.stack,
        modifier = Modifier.fillMaxSize(),
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is CameraScreenComponent.Child.CameraTakePictureChild -> {
                CameraTakePhotoContent(component = child.component)
            }
        }

    }
}