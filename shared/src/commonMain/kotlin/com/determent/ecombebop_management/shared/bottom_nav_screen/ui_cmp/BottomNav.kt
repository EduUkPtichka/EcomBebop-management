package com.determent.ecombebop_management.shared.bottom_nav_screen.ui_cmp

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.bottom_nav_screen.BottomNavScreenComponent
import com.determent.ecombebop_management.shared.util_compose.noRippleClickable
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR


/*
 * selectedItem - поднять в BottomNavScreenComponent как отдельный observable state .
 */
@Composable
fun BottomNav(
    listItems: List<BottomNavScreenComponent.BottomNavScreenModel>,
) {

    var selectedItem by remember { mutableIntStateOf(0) }

    BottomNavigation(
        windowInsets = BottomNavigationDefaults.windowInsets,
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)),
        backgroundColor = colorResource(MR.colors.white),
    ) {
        listItems.forEachIndexed { index, bottomNavScreenModel ->

            // Для отключения эффекта пульсации (Ripple)
            CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                BottomNavigationItem(
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        bottomNavScreenModel.onSelectedScreen()
                    },
                    icon = { Icon(icon = bottomNavScreenModel.selectedIcon) },
                    modifier = Modifier
                        .noRippleClickable {

                        }
                )
            }

        }
    }
}

@Composable
private fun Icon(icon: @Composable () -> Painter) {
    Icon(
        painter = icon(),
        contentDescription = null,
        modifier = Modifier
            .size(24.dp),
    )
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}
