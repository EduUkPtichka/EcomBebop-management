@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.determent.ecombebop_management.shared.a_camera.specific_platform

import androidx.compose.ui.graphics.ImageBitmap

expect class SharedImage {
    fun toByteArray(): ByteArray?
    fun toImageBitmap(): ImageBitmap?
}