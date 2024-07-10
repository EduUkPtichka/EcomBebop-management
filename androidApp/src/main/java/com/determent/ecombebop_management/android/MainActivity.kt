package com.determent.ecombebop_management.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.determent.ecombebop_management.shared.camera.camera_screen.DefaultCameraScreenComponent
import com.determent.ecombebop_management.shared.camera.camera_screen.presenter_cmp.CameraScreenContent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val rootDecompose = DefaultRootComponent(
//            componentContext = defaultComponentContext(),
//            storeFactory = DefaultStoreFactory()
//        )

        val camera = DefaultCameraScreenComponent(
            componentContext = defaultComponentContext()
        )

        setContent {

            CameraScreenContent(component = camera)
            
//            val camera = DefaultCameraComponent(
//                componentContext = defaultComponentContext(),
//            )


//            RootContentScreen(
//                component = rootDecompose,
//                modifier = Modifier.fillMaxSize()
//            )
        }
    }
}








