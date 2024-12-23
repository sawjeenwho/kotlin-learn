package OOP.Corporation

import OOP.Corporation.products.Enums.PositionType

class Assistant(
    id: Int,
    name: String,
    age: Int,
    salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    positionType = PositionType.ASSISTANT
), Cleaner, Supplier {
    override fun work() {
        println("Assistant: I am talking on the phone....")
    }

    override fun clean() {
        println("I'm Assistant. I'm cleaning workplace...")
    }

    override fun buyItems() {
        println("I'm Assistant. I'm buying items...")
    }

    fun bringCoffee(count: Int = 1, type: String = "Cappuccino"): String {
        repeat(count) {
            println("Get up...")
            println("Go to the coffe machine...")
            println("Press the \"$type\" button...")
            println("Wait for the $type to be prepared...")
            println("Bring coffe to the director...")
            println("Put coffe on the table...")
            println("Return to the workspace...")
        }
        return type
    }
}