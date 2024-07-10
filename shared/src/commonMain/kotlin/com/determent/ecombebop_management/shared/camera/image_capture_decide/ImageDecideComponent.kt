package com.determent.ecombebop_management.shared.camera.image_capture_decide

import androidx.compose.ui.graphics.ImageBitmap
import com.determent.ecombebop_management.shared.camera.specific_platform.BitmapShared

interface ImageDecideComponent {

    val model: ImageBitmap

    fun onUcePhotoClicked()
    fun onCloseCleanUpClicked()

}

