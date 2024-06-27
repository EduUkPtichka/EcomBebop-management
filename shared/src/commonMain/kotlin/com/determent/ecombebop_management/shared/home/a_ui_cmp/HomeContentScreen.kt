package com.determent.ecombebop_management.shared.home.a_ui_cmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home.a_domain.decompose.HomeComponent
import com.determent.ecombebop_management.shared.home_content.list_product.a_ui_cmp.ListProductContent

@Composable
fun HomeContentScreen(
    component: HomeComponent,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
    ) {
        ListProductContent(
            component = component.childListProductComponent,
            modifier = Modifier
                .fillMaxSize()
        )
    }

}