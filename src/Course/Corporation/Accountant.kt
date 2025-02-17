package Course.Corporation

import Course.Corporation.Repositories.ProductCardRepository
import Course.Corporation.Repositories.WorkersRepository
import Course.Corporation.products.AppliancesCard
import Course.Corporation.products.Enums.OperationCode
import Course.Corporation.products.Enums.PositionType
import Course.Corporation.products.Enums.ProductType
import Course.Corporation.products.FoodProductsCard
import Course.Corporation.products.ShoesCard


data class Accountant(
    override val id: Int,
    override val age: Int,
    override val name: String,
    override val salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    positionType = PositionType.ACCOUNTANT
), Cleaner, Supplier {


    private val workersRepository = WorkersRepository
    private val productCardRepository = ProductCardRepository

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
                OperationCode.EXIT -> {
                    workersRepository.changeFile()
                    productCardRepository.saveChanges()
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> registerItem()
                OperationCode.SHOW_ALL_ITEM -> showAllItem()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployee()
                OperationCode.CHANGE_SALARY -> changeSalary()
                OperationCode.CHANGE_AGE -> changeAge()
            }
        }
    }

    private fun changeAge() {
        print("Enter employee's id to change age: ")
        val changeAgeIndex = readln().toInt()
        print("Enter new age: ")
        val newAge = readln().toInt()
        workersRepository.changeAge(changeAgeIndex, newAge)
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

    override fun copy(id: Int, name: String, salary: Int, age: Int, positionType: PositionType): Worker { // а это мы переопределили метод родителя
        return copy(id = id, age = age, name = name, salary = salary) // метод был вызван под копотом и копирует текущий класс
    }

    private fun fireAnEmployee() {
        print("Enter employee's id to fire: ")
        val fireIndex = readln().toInt()
        workersRepository.fireAnEmployee(fireIndex)
    }

    private fun showAllEmployee() {
        val employees = workersRepository.workers
        for (employee in employees) {
            employee.printInfo()
        }

    }

    private fun removeProductCard() {
        print("Enter card name: ")
        val name = readln()
        productCardRepository.removeProductCard(name)
    }


    private fun showAllItem() {
        val cards = productCardRepository.productCards
        for (card in cards) {
            card.printInfo()
        }
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
        productCardRepository.registerItem(card)
    }
}
