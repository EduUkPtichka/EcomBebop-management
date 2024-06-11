package com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild

@Composable
fun BMContentManagement(
    onClick: () -> Unit,
    icon: Painter,
) {

    val hazeState = remember { HazeState() }

    Box(
        modifier = Modifier
            .border(
                width = Dp.Hairline,
                color = Color.Black,
                shape = RoundedCornerShape(22.dp)
            )
            .haze(
                hazeState,
                HazeStyle(
                    tint = Color.White.copy(alpha = 0.2f),
                    blurRadius = 5.dp,
                    noiseFactor = 0.01f
                )
            )
            .fillMaxHeight()
            .width(80.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .hazeChild(
                    state = hazeState,
                    shape = RoundedCornerShape(22.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(22.dp)),
                tint = Color.Black.copy(alpha = 0.9f)
            )

        }
    }
}