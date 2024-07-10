package com.determent.ecombebop_management.shared.camera.camera_take_picture

import androidx.compose.ui.graphics.ImageBitmap
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.camera.image_capture_decide.DefaultImageDecideComponent
import com.determent.ecombebop_management.shared.camera.image_capture_decide.ImageDecideComponent
import com.determent.ecombebop_management.shared.camera.model.ImageBitmapModel
import com.determent.ecombebop_management.shared.camera.specific_platform.BitmapShared
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

class DefaultCameraTakePhotoComponent(
    componentContext: ComponentContext,
) : CameraTakePhotoComponent, ComponentContext by componentContext {

    private val imageDecideNav = SlotNavigation<ConfigImageDecide>()

    private val _childSlotImageDecide: Value<ChildSlot<*, ImageDecideComponent>> =
        childSlot(
            source = imageDecideNav,
            serializer = ConfigImageDecide.serializer(),
            handleBackButton = true,
        ) { config, childComponentContext ->
            DefaultImageDecideComponent(
                componentContext = childComponentContext,
                imageBitmap = config.imageBitmap!!,
                onUcePhoto = {

                },
                onCloseCleanUp = {
                    imageDecideNav::dismiss
                    cleanUpModel()
                }


            )
        }

    override val childSlotImageDecide: Value<ChildSlot<*, ImageDecideComponent>>
        get() = _childSlotImageDecide

    private val _model: MutableStateFlow<ImageBitmapModel> = MutableStateFlow(
        ImageBitmapModel()
    )

    override val model: StateFlow<ImageBitmapModel> = _model

    override fun onTakePicturePhoto(bitmap: ImageBitmapModel) {
        _model.value = model.value.copy(bitmapImage = bitmap.bitmapImage)
        showImageDecide(bitmapImage = model.value)
    }

    private fun showImageDecide(bitmapImage: ImageBitmapModel) {
        imageDecideNav.activate(ConfigImageDecide(imageBitmap = bitmapImage.bitmapImage!!.toImageBitmap()))
    }

    private fun cleanUpModel() {
        _model.value = model.value.copy(bitmapImage = null)
    }

    @Serializable
    private data class ConfigImageDecide(
        val imageBitmap: ImageBitmap? = null
    )

}


