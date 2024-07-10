package com.determent.ecombebop_management.shared.camera.camera_screen

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.camera.camera_take_picture.CameraTakePhotoComponent

interface CameraScreenComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        class CameraTakePictureChild(val component: CameraTakePhotoComponent) : Child()
    }
}