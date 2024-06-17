package com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/*
 * Резервная идея!
 */

@Composable
fun CardScaffold(
    imageContent: @Composable () -> Unit,
    saleContent: @Composable () -> Unit,
    textPrice: @Composable () -> Unit,
    textInfo: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    )
}

@Composable
private fun ImageContent() {

}

@Composable
private fun saleContent() {

}

@Composable
private fun TextPrice() {

}

@Composable
private fun textInfo() {

}
