package Course.Corporation.Repositories

import Course.Corporation.ProductCard
import Course.Corporation.products.AppliancesCard
import Course.Corporation.products.Enums.ProductType
import Course.Corporation.products.FoodProductsCard
import Course.Corporation.products.ShoesCard
import java.io.File

object ProductCardRepository {


    private val file = File("product_cards.txt")
    private val _productCards = loadAllCards()
    val productCards
        get() = _productCards.toList()


    private fun loadAllCards(): MutableSet<ProductCard> {
        val cards = mutableSetOf<ProductCard>()
        val content = file.readText().trim()
        if (content.isEmpty()) {
            return cards
        }
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodProductsCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    AppliancesCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoesCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun removeProductCard(name: String) {
        for (card in _productCards) {
            if (card.name == name) {
                _productCards.remove(card)
                break
            }
        }
    }

    fun registerItem(productCard: ProductCard) {
        _productCards.add(productCard)
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
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (productCard in _productCards) {
            content.append("${productCard.name}%${productCard.brand}%${productCard.price}%")
            when (productCard) {
                is FoodProductsCard -> {
                    val productCaloric = productCard.caloric
                    content.append("$productCaloric%")
                }

                is AppliancesCard -> {
                    val productWattage = productCard.wattage
                    content.append("$productWattage%")
                }

                is ShoesCard -> {
                    val productSize = productCard.size
                    content.append("$productSize%")
                }
            }
            content.append("${productCard.productType}\n")
        }
        file.writeText(content.toString())
    }
}