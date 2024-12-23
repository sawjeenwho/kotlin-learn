package OOP.Corporation

import OOP.Corporation.products.Enums.PositionType

class Director(
    id: Int,
    name: String,
    age: Int,
    salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    positionType = PositionType.DIRECTOR
), Supplier {

    override fun work() {
        println("Director: I'm drinking coffee...")
    }
    override fun buyItems() {
        println("I'm Director. I'm buying items...")
    }

    fun takeCoffe(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("Thank you! ${assistant.name}! The $drinkName is very tasty")
    }

    fun assistantWorkCheck(consultant: Consultant) {
        val count = consultant.serveClient()
        println("Consultan ${consultant.name} serve $count clients. ")
    }
}