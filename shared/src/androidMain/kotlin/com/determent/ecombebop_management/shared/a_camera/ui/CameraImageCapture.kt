package com.determent.ecombebop_management.shared.a_camera.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.util.Log
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat
import com.determent.ecombebop_management.shared.a_camera.bloc.CameraComponent
import com.determent.ecombebop_management.shared.a_camera.specific_platform.SharedImage
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Composable
fun CameraImageCapture(
    component: CameraComponent
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current

    val controller = remember {
        LifecycleCameraController(context).apply {
            this.bindToLifecycle(lifecycleOwner)
            //this.cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            this.setEnabledUseCases(CameraController.IMAGE_CAPTURE)



            coroutineScope.launch {
                context.getCameraProvider()
            }

        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            CameraBottomBar(
                takePicture = {
                    takePicture(
                        lifecycleCameraController = controller,
                        context = context,
                        onTakePhoto = component::onTakePhoto
                    )
                },
                onBackClicked = { },
                ucePhoto = { }
            )
        }
    ) { paddingValues ->
        CameraPreview(
            lifecycleCameraController = controller,
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

private suspend fun Context.getCameraProvider(): ProcessCameraProvider = suspendCoroutine { continuation ->
    ProcessCameraProvider.getInstance(this).also { future ->
        future.addListener(
            {
                continuation.resume(future.get())
            },
            executor
        )
    }
}

private val Context.executor: Executor
    get() = ContextCompat.getMainExecutor(this)

//private suspend fun Context.cameraProvider(): ProcessCameraProvider = suspendCoroutine { continuation ->
//    val lifecycleProvider = ProcessCameraProvider.getInstance(this)
//
//    lifecycleProvider.addListener(
//        {
//            continuation.resume(lifecycleProvider.get())
//        },
//        ContextCompat.getMainExecutor(this)
//    )
//}

private fun takePicture(
    lifecycleCameraController: LifecycleCameraController,
    context: Context,
    onTakePhoto: (SharedImage) -> Unit,
) {
    lifecycleCameraController.takePicture(
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {
                val matrix = Matrix().apply {
                    postRotate(image.imageInfo.rotationDegrees.toFloat())
                }

                val rotatedBitmap = Bitmap.createBitmap(
                    image.toBitmap(),
                    0,
                    0,
                    image.width,
                    image.height,
                    matrix,
                    true
                )
                val sharedImage = SharedImage(rotatedBitmap)
                onTakePhoto(sharedImage)
            }

            override fun onError(exception: ImageCaptureException) {
                super.onError(exception)
                Log.e("Camera", "Couldn't take photo: ", exception)
            }
        }
    )
}

