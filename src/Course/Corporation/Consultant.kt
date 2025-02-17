package Course.Corporation

import Course.Corporation.products.Enums.PositionType
import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    positionType = PositionType.CONSULTANT
), Cleaner {

    override fun work() {
        println("Consultant: I am consulting clients...")
    }

    override fun clean() {
        println("I'm Consultant. I'm cleaning workplace...")
    }

    fun hello() {
        print("Hello! My name is $name.")
        if (age > 0) {
            println(" I am $age years old.")
        }
    }

    fun serveClient(): Int {
        val count = Random.nextInt(0, 100)
        repeat(count) {
            println("Client served")
        }
        return count
    }
    override fun copy(id: Int, name: String, salary: Int, age: Int, positionType: PositionType): Worker { // а это мы переопределили метод родителя
        return copy(id = id, age = age, name = name, salary = salary) // метод был вызван под копотом и копирует текущий класс
    }

}