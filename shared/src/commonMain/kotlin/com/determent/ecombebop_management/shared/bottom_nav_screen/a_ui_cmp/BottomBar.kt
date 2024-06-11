package com.determent.ecombebop_management.shared.bottom_nav_screen.a_ui_cmp

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.runtime.Composable
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_ui_cmp.state_manager.StateManagerBottomNavScreen.BottomBarItem.Companion.bottomBarItems


@Composable
fun BottomBar(
    selectedItem: Int
) {

    BottomNavigation(windowInsets = BottomNavigationDefaults.windowInsets) {
        bottomBarItems.forEachIndexed { index, items ->
            BottomBarItem(
                selected = selectedItem == index,
                onClick = {},
                items = items
            )
        }
    }
}