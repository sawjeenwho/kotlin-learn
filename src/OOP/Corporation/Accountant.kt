package OOP.Corporation

import OOP.Corporation.products.AppliancesCard
import OOP.Corporation.products.Enums.OperationCode
import OOP.Corporation.products.FoodProductsCard
import OOP.Corporation.products.Enums.ProductType
import OOP.Corporation.products.ShoesCard


class Accountant(
    name: String
) : Worker(name) {
    override fun work() {
        registrationProduct()
    }
    fun registrationProduct() {
        val operationTypes = OperationCode.entries
        while (true) {
            print("Enter the operation code. ")
            for ((index, code) in operationTypes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationTypes.size - 1) {
                    print(", ")
                } else {
                    print(": ")
                }
            }
            val operationCodeIndex = readln().toInt()
            val operationCode = operationTypes[operationCodeIndex]
            when(operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerItem()
            }
        }

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
                FoodProductsCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    caloric = productCaloric
                )
            }
            ProductType.APPLIANCE -> {
                print("Enter the product wattage: ")
                val productWattage = readln().toInt()
                AppliancesCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = productWattage
                )
            }
            ProductType.SHOE -> {
                print("Enter the product size: ")
                val productSize = readln().toFloat()
                ShoesCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    size = productSize
                )
            }
        }
        card.printInfo()
    }
}
