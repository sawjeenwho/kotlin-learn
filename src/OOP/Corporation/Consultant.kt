package OOP.Corporation

import OOP.Corporation.products.Enums.PositionType
import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int = 0,
    salary: Int
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

}