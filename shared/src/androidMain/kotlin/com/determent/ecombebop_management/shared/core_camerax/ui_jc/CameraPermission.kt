//@file:OptIn(ExperimentalPermissionsApi::class)
//
//package com.determent.ecombebop_management.shared.core_camerax.ui_jc
//
//import androidx.compose.runtime.Composable
//import com.google.accompanist.permissions.ExperimentalPermissionsApi
//import com.google.accompanist.permissions.PermissionState
//import com.google.accompanist.permissions.isGranted
//import com.google.accompanist.permissions.rememberPermissionState
//
//@Composable
//fun CameraPermission(
//
//) {
//
//    val cameraProgression: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
//
//    CameraPermissionContent(
//        cameraXContent = { /*TODO*/ },
//        noPermissionContent = { /*TODO*/ },
//        isPermission = cameraProgression.status.isGranted,
//    )
//}
//
//@Composable
//fun CameraPermissionContent(
//    cameraXContent: () -> Unit,
//    noPermissionContent: () -> Unit,
//    isPermission: Boolean,
//) {
//    if (isPermission) cameraXContent() else noPermissionContent()
//}