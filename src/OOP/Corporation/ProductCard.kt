package OOP.Corporation

import OOP.Corporation.products.Enums.ProductType

abstract class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val productType: ProductType
) {

    fun printInfo() {
        println(this)
    }
}