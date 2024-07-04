package com.determent.ecombebop_management.shared.a_camera.camera_permission_platform.domain.decompose

import com.arkivanov.decompose.ComponentContext
import com.determent.ecombebop_management.shared.a_camera.camera_permission_platform.domain.model.CameraPermissionModel
import com.determent.ecombebop_management.shared.util.decompose_util.componentCoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultCameraPermissionComponent(
    componentContext: ComponentContext,
) : CameraPermissionComponent, ComponentContext by componentContext {

    private val componentCoroutineScope = componentCoroutineScope()

    override val state: StateFlow<CameraPermissionModel>
        get() = _state

    private val _state: MutableStateFlow<CameraPermissionModel> = MutableStateFlow(
        CameraPermissionModel(
            permissionGranted = false,
            shouldShowRationale = false,
        )
    )

    init {

    }

    override fun updatePermissionStatus(cameraPermissionModel: CameraPermissionModel) {
        componentCoroutineScope.launch {
            _state.value = state.value.copy(
                permissionGranted = cameraPermissionModel.permissionGranted,
                shouldShowRationale = cameraPermissionModel.shouldShowRationale
            )
        }
    }



}