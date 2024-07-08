package com.determent.ecombebop_management.shared.home_content.add_product.ui_cmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.determent.ecombebop_management.shared.home_content.add_product.bloc.AddProductComponent
import com.determent.ecombebop_management.shared.my_material.MyColumnCenter
import com.determent.ecombebop_management.shared.my_material.MyTopAppBar

@Composable
fun AddProductContent(
    component: AddProductComponent,
) {

    val model by component.model.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            MyTopAppBar(
                onClick = { }
            )
        }
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyColumnCenter(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            ) {
                CardProductItemRelation(
                    itemProduct = model.productItemRelation,
                    onClick = {}
                )
            }

            VerticalLazyAddProduct()
        }

    }
}




