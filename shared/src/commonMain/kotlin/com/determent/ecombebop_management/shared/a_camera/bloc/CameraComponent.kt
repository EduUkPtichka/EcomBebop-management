package com.determent.ecombebop_management.shared.a_camera.bloc

import androidx.compose.ui.graphics.ImageBitmap
import com.determent.ecombebop_management.shared.a_camera.specific_platform.SharedImage
import kotlinx.coroutines.flow.StateFlow

interface CameraComponent {

    val model: StateFlow<List<SharedImage>>

    fun onTakePhoto(bitmap: SharedImage)
}