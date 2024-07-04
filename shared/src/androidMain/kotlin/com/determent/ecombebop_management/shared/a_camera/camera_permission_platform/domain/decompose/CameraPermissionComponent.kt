package com.determent.ecombebop_management.shared.a_camera.camera_permission_platform.domain.decompose

import com.determent.ecombebop_management.shared.a_camera.camera_permission_platform.domain.model.CameraPermissionModel
import kotlinx.coroutines.flow.StateFlow

interface CameraPermissionComponent {

    val state: StateFlow<CameraPermissionModel>

    fun updatePermissionStatus(cameraPermissionModel: CameraPermissionModel)

    companion object {
        const val PERMISSION_CAMERA = android.Manifest.permission.CAMERA
    }

}