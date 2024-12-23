package OOP.Corporation.products

import OOP.Corporation.ProductCard
import OOP.Corporation.products.Enums.ProductType

class FoodProductsCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name, brand, price, ProductType.FOOD) {
    override fun toString(): String {
        return ("Name: $name, Brand: $brand, Price: $price, Product Type: ${productType.title} Caloric: $caloric")
    }
}