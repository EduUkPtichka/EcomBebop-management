package com.determent.ecombebop_management.shared.home_content.list_product.repository

import com.determent.ecombebop_management.shared.home_content.list_product.model.ProductItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductItemRepositoryImpl : ProductItemRepository {
    override suspend fun getListProductItem(): Flow<List<ProductItemModel>> {
        return flowOf(
            listOf(
                ProductItemModel(
                    mainImage = 1,
                    price = 11000,
                    discount = 0,
                    priceCalculated = 5400,
                    title = "String",
                    brand = "Brend"
                ),
                ProductItemModel(
                    mainImage = 1,
                    price = 70000,
                    discount = 66,
                    priceCalculated = 3445,
                    title = "Платье",
                    brand = "Brend"
                ),
                ProductItemModel(
                    mainImage = 1,
                    price = 11,
                    discount = 66,
                    priceCalculated = 0,
                    title = "Футболка",
                    brand = "Brend"
                ),
                ProductItemModel(
                    mainImage = 1,
                    price = 112124,
                    discount = 0,
                    priceCalculated = 0,
                    title = "Футболка",
                    brand = "Brend"
                ),
                ProductItemModel(
                    mainImage = 1,
                    price = 70000,
                    discount = 0,
                    priceCalculated = 0,
                    title = "Футболка",
                    brand = "Brend"
                ),
            )
        )
    }
}