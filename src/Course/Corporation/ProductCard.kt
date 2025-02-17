package Course.Corporation

import Course.Corporation.products.Enums.ProductType

abstract class ProductCard(
    open val name: String,
    open val brand: String,
    open val price: Int,
    open val productType: ProductType
) {

    fun printInfo() {
        println(this)
    }
}