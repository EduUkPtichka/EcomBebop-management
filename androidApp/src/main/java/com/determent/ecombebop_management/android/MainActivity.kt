package com.determent.ecombebop_management.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.determent.ecombebop_management.shared.a_camera.ui.CameraImageCapture
import com.determent.ecombebop_management.shared.a_camera.bloc.DefaultCameraComponent
import com.determent.ecombebop_management.shared.a_root.root_decompose.DefaultRootComponent
import com.determent.ecombebop_management.shared.a_root.root_decompose.RootContentScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootDecompose = DefaultRootComponent(
            componentContext = defaultComponentContext(),
            storeFactory = DefaultStoreFactory()
        )

        setContent {

//            val camera = DefaultCameraComponent(
//                componentContext = defaultComponentContext(),
//            )
//
//            CameraImageCapture(camera)

            RootContentScreen(
                component = rootDecompose,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}








