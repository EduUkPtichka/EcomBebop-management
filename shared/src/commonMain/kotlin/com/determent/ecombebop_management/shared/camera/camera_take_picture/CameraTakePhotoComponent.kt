package com.determent.ecombebop_management.shared.camera.camera_take_picture

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.value.Value
import com.determent.ecombebop_management.shared.camera.image_capture_decide.ImageDecideComponent
import com.determent.ecombebop_management.shared.camera.model.ImageBitmapModel
import kotlinx.coroutines.flow.StateFlow

interface CameraTakePhotoComponent {

    val childSlotImageDecide: Value<ChildSlot<*, ImageDecideComponent>>

    val model: StateFlow<ImageBitmapModel>

    fun onTakePicturePhoto(bitmap: ImageBitmapModel)
}

