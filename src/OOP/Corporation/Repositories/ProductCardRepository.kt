package OOP.Corporation.Repositories

import OOP.Corporation.ProductCard
import OOP.Corporation.products.AppliancesCard
import OOP.Corporation.products.Enums.ProductType
import OOP.Corporation.products.FoodProductsCard
import OOP.Corporation.products.ShoesCard
import java.io.File

class ProductCardRepository {
    private val file = File("product_cards.txt")





     fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodProductsCard -> {
                val productCaloric = productCard.caloric
                file.appendText("$productCaloric%")
            }

            is AppliancesCard -> {
                val productWattage = productCard.wattage
                file.appendText("$productWattage%")
            }

            is ShoesCard -> {
                val productSize = productCard.size
                file.appendText("$productSize%")
            }
        }
        file.appendText("${productCard.productType}\n")
    }

     fun registerItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()
        val card = when (productType) {
            ProductType.FOOD -> {
                print("Enter the product caloric: ")
                val productCaloric = readln().toInt()
                FoodProductsCard(productName, productBrand, productPrice, productCaloric)
            }

            ProductType.APPLIANCE -> {
                print("Enter the product wattage: ")
                val productWattage = readln().toInt()
                AppliancesCard(productName, productBrand, productPrice, productWattage)
            }

            ProductType.SHOE -> {
                print("Enter the product size: ")
                val productSize = readln().toFloat()
                ShoesCard(productName, productBrand, productPrice, productSize)
            }
        }
        saveProductCardToFile(card)
    }
}