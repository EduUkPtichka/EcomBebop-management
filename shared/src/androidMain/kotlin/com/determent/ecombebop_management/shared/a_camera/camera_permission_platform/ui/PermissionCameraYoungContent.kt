package com.determent.ecombebop_management.shared.a_camera.camera_permission_platform.ui

//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun PermissionCameraYoungContent(
//    component: CameraPermissionComponent
//) {
//
//    val permissionState = rememberPermissionState(CameraPermissionComponent.PERMISSION_CAMERA)
//    val model by component.state.collectAsState()
//
//    LaunchedEffect(permissionState.status.isGranted, permissionState.status.shouldShowRationale) {
//        component.updatePermissionStatus(
//            model.copy(
//                permissionGranted = permissionState.status.isGranted,
//                shouldShowRationale = permissionState.status.shouldShowRationale
//            )
//        )
//    }
//
//    if (model.permissionGranted) {
//        Text("Camera permission Granted")
//    } else {
//        Column {
//            val textToShow = if (model.shouldShowRationale) {
//                "This permission is important for this app. Please grant the permission."
//            } else {
//                "Camera not available"
//            }
//
//            Text(textToShow)
//            Spacer(modifier = Modifier.height(8.dp))
//            Button(onClick = { permissionState.launchPermissionRequest() }) {
//                Text("Request permission")
//            }
//        }
//    }
//
//
//}