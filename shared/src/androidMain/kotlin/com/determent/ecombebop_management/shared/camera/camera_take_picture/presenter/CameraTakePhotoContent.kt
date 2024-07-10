package com.determent.ecombebop_management.shared.camera.camera_take_picture.presenter

import android.content.Context
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.core.UseCase
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.determent.ecombebop_management.shared.camera.camera_take_picture.CameraTakePhotoComponent
import com.determent.ecombebop_management.shared.camera.image_capture_decide.ImageDecideContent
import com.determent.ecombebop_management.shared.camera.model.ImageBitmapModel
import com.determent.ecombebop_management.shared.camera.specific_platform.BitmapShared
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Composable
fun CameraTakePhotoContent(
    component: CameraTakePhotoComponent,
    modifier: Modifier = Modifier,
) {

    val dialogSlot by component.childSlotImageDecide.subscribeAsState()

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var previewUseCase by remember {
        mutableStateOf<UseCase>(Preview.Builder().build())
    }

    val imageCapture = remember { ImageCapture.Builder().build() }

    Scaffold(
        topBar = { CameraTopBar() },
        bottomBar = {
            CameraBottomBar(
                onTakePicture = {
                    takePicture(
                        imageCapture = imageCapture,
                        executor = context.executor,
                        onTakePicturePhoto = component::onTakePicturePhoto
                    )
                },
                onClickBackNav = { },
            )
        }
    ) { innerPadding ->
        CameraPreview(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),

            onUseCase = { hostingProvider ->
                previewUseCase = hostingProvider
            }
        )

        dialogSlot.child?.instance.also {
            if (it != null) {
                ImageDecideContent(component = it)
            }
        }

    }

    LaunchedEffect(previewUseCase) {
        val cameraProvider = context.getCameraProvider()
        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                previewUseCase,
                imageCapture
            )

        } catch (ex: Exception) {
            Log.e("CameraCapture", "Failed to bind camera use cases", ex)
        }

    }

}

@Composable
private fun CameraTopBar() {
    Box(
        modifier = Modifier
            .background(colorResource(MR.colors.black))
            .fillMaxWidth()
            .height(100.dp)
    )
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

private fun takePicture(
    imageCapture: ImageCapture,
    executor: Executor,
    onTakePicturePhoto: (ImageBitmapModel) -> Unit
) {
    imageCapture.takePicture(
        executor,
        object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {

                val bitmapImage = ImageBitmapModel(bitmapImage = BitmapShared(image.toBitmap()))

                onTakePicturePhoto(bitmapImage)
                image.close()
            }

            override fun onError(exception: ImageCaptureException) {

            }
        }
    )
}