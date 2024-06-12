package com.determent.ecombebop_management.shared.bottom_nav_screen.a_ui_cmp

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_domain.decompose.BottomNavScreenComponent
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
            BottomNavigationItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    bottomNavScreenModel.onSelectedScreen()
                },
                icon = { Icon(icon = bottomNavScreenModel.selectedIcon) },
            )
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

