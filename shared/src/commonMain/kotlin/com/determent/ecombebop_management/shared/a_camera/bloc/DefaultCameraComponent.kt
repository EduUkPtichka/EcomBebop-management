package com.determent.ecombebop_management.shared.a_camera.bloc

import com.arkivanov.decompose.ComponentContext
import com.determent.ecombebop_management.shared.a_camera.specific_platform.SharedImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class DefaultCameraComponent(
    componentContext: ComponentContext
) : CameraComponent, ComponentContext by componentContext {

    override val model: StateFlow<List<SharedImage>>
        get() = _model.asStateFlow()

    private val _model = MutableStateFlow<List<SharedImage>>(emptyList())

    override fun onTakePhoto(bitmap: SharedImage) {
        _model.value = listOf(bitmap)
    }

}