package OOP.Corporation

import OOP.Corporation.Repositories.WorkersRepository
import OOP.Corporation.products.AppliancesCard
import OOP.Corporation.products.Enums.OperationCode
import OOP.Corporation.products.FoodProductsCard
import OOP.Corporation.products.Enums.ProductType
import OOP.Corporation.products.Enums.PositionType
import OOP.Corporation.products.ShoesCard
import java.io.File


class Accountant(
    id: Int,
    age: Int,
    name: String,
    salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    positionType = PositionType.ACCOUNTANT
), Cleaner, Supplier {


    private val workersRepository = WorkersRepository()
    private val file = File("product_cards.txt")

    override fun clean() {
        println("I'm Accountant. I'm cleaning workplace...")
    }

    override fun buyItems() {
        println("I'm Accountant. I'm buying items...")
    }

    override fun work() {
        registrationProduct()
    }

    private fun registrationProduct() {
        val operationTypes = OperationCode.entries
        while (true) {
            println("Enter the operation code.")
            for ((index, code) in operationTypes.withIndex()) {
                print("$index - ${code.title}\n")
            }
            val operationCodeIndex = readln().toInt()
            val operationCode = operationTypes[operationCodeIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerItem()
                OperationCode.SHOW_ALL_ITEM -> showAllItem()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployee()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun registerNewEmployee() {
        val workerTypes = PositionType.entries
        print("Choose position ")
        for ((index, type) in workerTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < workerTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val workerTypeIndex = readln().toInt()
        val employeePosition = workerTypes[workerTypeIndex]
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        print("Enter salary: ")
        val salary = readln().toInt()

        val employee = when (employeePosition) {
            PositionType.DIRECTOR -> Director(id, name, age, salary)
            PositionType.ACCOUNTANT -> Accountant(id, age, name, salary)
            PositionType.ASSISTANT -> Assistant(id, name, age, salary)
            PositionType.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(employee)
    }

    private fun changeSalary() {
        print("Enter employee's id to change salary: ")
        val changeSalaryIndex = readln().toInt()
        print("Enter new salary: ")
        val newSalary = readln().toInt()
        workersRepository.changeSalary(changeSalaryIndex, newSalary)
    }

    fun fireAnEmployee() {
        print("Enter employee's id to fire: ")
        val fireIndex = readln().toInt()
        workersRepository.fireAnEmployee(fireIndex)
    }

    private fun showAllEmployee() {
        val employess = workersRepository.loadAllEmployee()
        for (employee in employess) {
            employee.printInfo()
        }

    }

    private fun removeProductCard() {
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter card name: ")
        val name = readln()
        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()
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


    private fun showAllItem() {
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun saveProductCardToFile(productCard: ProductCard) {
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

    private fun registerItem() {
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
