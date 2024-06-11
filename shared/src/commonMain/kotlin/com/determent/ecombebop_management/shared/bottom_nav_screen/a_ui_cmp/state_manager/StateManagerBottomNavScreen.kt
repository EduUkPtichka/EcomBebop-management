package com.determent.ecombebop_management.shared.bottom_nav_screen.a_ui_cmp.state_manager

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

sealed interface StateManagerBottomNavScreen {

    data class BottomBarItem(
        val title: String? = null,
        val contentDescription: String? = null,
        val selectedIcon: @Composable () -> Painter,
        val unselectedIcon: @Composable (() -> Painter)? = null,
    ) {
        companion object {
            val bottomBarItems = listOf(
                BottomBarItem(
                    selectedIcon = { ResourceBN.svg_home_selected() }
                ),
                BottomBarItem(
                    selectedIcon = { ResourceBN.svg_catalog_selected() }
                ),
                BottomBarItem(
                    selectedIcon = { ResourceBN.svg_home_unselected() }
                )
            )
        }
    }

    private object ResourceBN {
        @Composable
        inline fun svg_home_selected() = painterResource(MR.images.svg_home)

        @Composable
        inline fun svg_home_unselected() = painterResource(MR.images.svg_catalog_plus)

        @Composable
        inline fun svg_catalog_selected() = painterResource(MR.images.svg_chat)


    }
}