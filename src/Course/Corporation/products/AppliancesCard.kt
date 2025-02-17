package Course.Corporation.products

import Course.Corporation.ProductCard
import Course.Corporation.products.Enums.ProductType

data class AppliancesCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val wattage: Int
) : ProductCard(name, brand, price, ProductType.APPLIANCE)