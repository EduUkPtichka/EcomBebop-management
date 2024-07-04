package com.determent.ecombebop_management.shared.a_camera.camera_platform.ui

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionRequired(
    permissionState: PermissionState,
    permissionNotGrantedContent: @Composable (() -> Unit),
    permissionNotAvailableContent: @Composable (() -> Unit),
    content: @Composable (() -> Unit),
) {
    when {
        permissionState.hasPermission -> {
            content()
        }

        permissionState.shouldShowRationale || !permissionState.permissionRequested -> {
            permissionNotGrantedContent()
        }

        else -> {
            permissionNotAvailableContent()
        }
    }
}