package com.determent.ecombebop_management.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.determent.ecombebop_management.shared.a_root.root_decompose.DefaultRootComponent
import com.determent.ecombebop_management.shared.a_root.root_decompose.RootContentScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootDecompose = DefaultRootComponent(
            componentContext = defaultComponentContext(),
        )

        setContent {
            RootContentScreen(
                component = rootDecompose,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

