package com.determent.ecombebop_management.shared.bottom_nav_screen.a_ui_cmp

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.bottom_nav_screen.a_ui_cmp.state_manager.StateManagerBottomNavScreen

@Composable
fun RowScope.BottomBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    items: StateManagerBottomNavScreen.BottomBarItem,
    modifier: Modifier = Modifier
) {

    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                painter = items.selectedIcon(),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        modifier = modifier

    )

}