package com.determent.ecombebop_management.shared.home_content.list_product.repository

import com.determent.ecombebop_management.shared.home_content.list_product.model.ProductItemModel
import kotlinx.coroutines.flow.Flow

interface ProductItemRepository {

    suspend fun getListProductItem(): Flow<List<ProductItemModel>>
}