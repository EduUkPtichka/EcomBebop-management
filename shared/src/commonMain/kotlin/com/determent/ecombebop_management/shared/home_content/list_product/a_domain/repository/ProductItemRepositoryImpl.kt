package com.determent.ecombebop_management.shared.home_content.list_product.a_domain.repository

import com.determent.ecombebop_management.shared.home_content.list_product.a_domain.model.ProductItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductItemRepositoryImpl : ProductItemRepository {
    override suspend fun getListProductItem(): Flow<List<ProductItem>> {
        return flowOf(
            listOf(
                ProductItem(
                    mainImage = 0x01,
                    price = 100,
                    discount = 10,
                    priceCalculated = 0,
                    title = "Product 1",
                    brand = "Brand A"
                ),
                ProductItem(
                    mainImage = 0x02,
                    price = 200,
                    discount = 20,
                    priceCalculated = 0,
                    title = "Product 2",
                    brand = "Brand B"
                ),
                ProductItem(
                    mainImage = 0x03,
                    price = 300,
                    discount = 30,
                    priceCalculated = 0,
                    title = "Product 3",
                    brand = "Brand C"
                ),
                ProductItem(
                    mainImage = 0x01,
                    price = 100,
                    discount = 10,
                    priceCalculated = 0,
                    title = "Product 1",
                    brand = "Brand A"
                ),
                ProductItem(
                    mainImage = 0x01,
                    price = 100,
                    discount = 10,
                    priceCalculated = 0,
                    title = "Product 1",
                    brand = "Brand A"
                ),
                ProductItem(
                    mainImage = 0x01,
                    price = 100,
                    discount = 10,
                    priceCalculated = 0,
                    title = "Product 1",
                    brand = "Brand A"
                ),
                ProductItem(
                    mainImage = 0x01,
                    price = 100,
                    discount = 10,
                    priceCalculated = 0,
                    title = "Product 1",
                    brand = "Brand A"
                ),
                ProductItem(
                    mainImage = 0x01,
                    price = 100,
                    discount = 10,
                    priceCalculated = 0,
                    title = "Product 1",
                    brand = "Brand A"
                ),
                ProductItem(
                    mainImage = 0x01,
                    price = 100,
                    discount = 10,
                    priceCalculated = 0,
                    title = "Product 1",
                    brand = "Brand A"
                ),
            )
        )
    }
}