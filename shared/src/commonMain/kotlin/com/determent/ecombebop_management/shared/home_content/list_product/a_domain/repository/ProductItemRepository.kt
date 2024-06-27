package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.repository

import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

interface ProductItemRepository {

    suspend fun getListProductItem(): Flow<List<ProductItem>>
}