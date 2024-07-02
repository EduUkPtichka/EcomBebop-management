package com.determent.ecombebop_management.shared.resource

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import dev.icerock.moko.resources.compose.fontFamilyResource
import org.example.library.MR

object MyTypography {

    @Composable
    fun SfProDisplayRegular(): FontFamily {
        return fontFamilyResource(MR.fonts.sf_pro_display_regular)
    }

}