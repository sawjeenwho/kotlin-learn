package Course.Corporation.products

import Course.Corporation.ProductCard
import Course.Corporation.products.Enums.ProductType

data class FoodProductsCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val caloric: Int
) : ProductCard(name, brand, price, ProductType.FOOD)