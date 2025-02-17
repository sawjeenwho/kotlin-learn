package Course.Corporation.products

import Course.Corporation.ProductCard
import Course.Corporation.products.Enums.ProductType

data class ShoesCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val size: Float
) : ProductCard(name, brand, price, ProductType.SHOE)