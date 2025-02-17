package Course.Corporation

import Course.Corporation.products.Enums.PositionType

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
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
    override fun copy(id: Int, name: String, salary: Int, age: Int, positionType: PositionType): Worker { // а это мы переопределили метод родителя
        return copy(id = id, age = age, name = name, salary = salary) // метод был вызван под копотом и копирует текущий класс
    }
}