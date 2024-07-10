@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "EXTERNAL_SERIALIZER_USELESS")

package com.determent.ecombebop_management.shared.camera.specific_platform

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import java.io.ByteArrayOutputStream


actual class BitmapShared(
    private val bitmap: Bitmap? = null
) {

    actual fun toByteArray(): ByteArray? {
        if (bitmap == null) {
            return null
        }
        val stream = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

        return stream.toByteArray()
    }

    actual fun toImageBitmap(): ImageBitmap? {
        return bitmap?.asImageBitmap()
    }

    companion object {
        fun fromByteArray(byteArray: ByteArray): BitmapShared {
            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            return BitmapShared(bitmap)
        }
    }
}