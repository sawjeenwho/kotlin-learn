package OOP.Corporation.products

import OOP.Corporation.ProductCard

class FoodProductsCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name, brand, price) {
    override fun printInfo() {
        super.printInfo()
        println("Caloric: $caloric")
    }
}