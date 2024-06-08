package com.determent.ecombebop_management.shared.home.banner_marketing.a_ui_cmp.content

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            .haze(
                hazeState,
                HazeStyle(
                    tint = Color.White.copy(alpha = 0.1f),
                    blurRadius = 10.dp,
                    noiseFactor = 0.01f
                )
            )
            .height(500.dp)
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .hazeChild(
                    state = hazeState,
                    shape = RoundedCornerShape(22.dp)
                )
                .border(
                    width = Dp.Hairline,
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = .8f),
                            Color.White.copy(alpha = .2f),
                        ),
                    ),
                    shape = RoundedCornerShape(22.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
                tint = Color.Black.copy(alpha = 0.6f)
            )

        }
    }
}