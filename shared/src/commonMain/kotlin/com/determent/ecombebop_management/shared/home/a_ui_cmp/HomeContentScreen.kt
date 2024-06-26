package com.determent.ecombebop_management.shared.home.a_ui_cmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.determent.ecombebop_management.shared.home.a_domain.decompose.HomeComponent

@Composable
fun HomeContentScreen(
    component: HomeComponent,
    modifier: Modifier = Modifier,
    listProductContent: () -> Unit
) {

    LazyColumn(
        modifier = modifier
    ) {
        listProductContent()
    }

}