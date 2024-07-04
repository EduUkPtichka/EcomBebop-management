package com.determent.ecombebop_management.shared.a_camera.camera_permission_platform.domain.model

data class CameraPermissionModel(
    val permissionGranted: Boolean = false,
    val shouldShowRationale: Boolean = false,
)