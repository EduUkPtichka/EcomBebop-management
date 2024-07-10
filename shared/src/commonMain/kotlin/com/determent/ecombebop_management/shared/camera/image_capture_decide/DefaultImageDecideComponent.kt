package com.determent.ecombebop_management.shared.camera.image_capture_decide

import androidx.compose.ui.graphics.ImageBitmap
import com.arkivanov.decompose.ComponentContext
import com.determent.ecombebop_management.shared.camera.specific_platform.BitmapShared

class DefaultImageDecideComponent(
    private val componentContext: ComponentContext,
    private val imageBitmap: ImageBitmap,
    private val onUcePhoto: () -> Unit,
    private val onCloseCleanUp: () -> Unit,
) : ImageDecideComponent, ComponentContext by componentContext {

    override val model: ImageBitmap
        get() = imageBitmap

    override fun onUcePhotoClicked() {
        onUcePhoto()
    }

    override fun onCloseCleanUpClicked() {
        onCloseCleanUp()
    }

}