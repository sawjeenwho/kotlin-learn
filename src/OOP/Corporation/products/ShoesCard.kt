package OOP.Corporation.products

import OOP.Corporation.ProductCard
import OOP.Corporation.products.Enums.ProductType

class ShoesCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
):ProductCard(name, brand, price, ProductType.SHOE) {
    override fun toString(): String {
        return ("Name: $name, Brand: $brand, Price: $price, Product Type: ${productType.title} Size: $size")
    }
}