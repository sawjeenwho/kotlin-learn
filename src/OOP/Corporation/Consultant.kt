package OOP.Corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0,
) : Worker(name, age) {

    override fun work() {
        println("I am consulting clients...")
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