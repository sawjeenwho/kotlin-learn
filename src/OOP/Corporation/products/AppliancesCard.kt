package OOP.Corporation.products

import OOP.Corporation.ProductCard
import OOP.Corporation.products.Enums.ProductType

class AppliancesCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
):ProductCard(name, brand, price, ProductType.APPLIANCE ) {
    override fun toString(): String {
        return ("Name: $name, Brand: $brand, Price: $price, Product Type: ${productType.title} Wattage: $wattage")
    }
}