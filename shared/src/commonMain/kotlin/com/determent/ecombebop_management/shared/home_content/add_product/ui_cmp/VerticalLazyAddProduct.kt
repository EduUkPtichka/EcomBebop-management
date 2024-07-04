package com.determent.ecombebop_management.shared.home_content.add_product.ui_cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.colorResource
import org.example.library.MR

@Composable
fun VerticalLazyAddProduct(

) {
    LazyColumn(
        modifier = Modifier
            .background(colorResource(MR.colors.black))
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item(1) {
            AddProductImageAndGallery()
        }
    }
}