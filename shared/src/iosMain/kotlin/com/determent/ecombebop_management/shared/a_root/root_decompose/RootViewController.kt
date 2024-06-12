package com.determent.ecombebop_management.shared.a_root.root_decompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun rootViewController(root: RootComponent): UIViewController =
    ComposeUIViewController {
        RootContentScreen(
            component = root,
            modifier = Modifier.fillMaxSize()
        )
    }

