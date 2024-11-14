package OOP

fun main() {
    val first = Person()
    val twice = Person()
    println("Enter 1s name: ")
    first.name = readln()

    println("Enter 2c name: ")
    twice.name = readln()

    println("Enter 1c age: ")
    first.age = readln().toInt()

    println("Enter 2c age: ")
    twice.age = readln().toInt()

    println("Enter 1c height: ")
    first.weight = readln().toInt()

    println("Enter 2c height: ")
    twice.weight = readln().toInt()

    println("Enter 1c weight: ")
    first.weight = readln().toInt()

    println("Enter 2c weight: ")
    twice.weight = readln().toInt()


    println("1. Name: \"${first.name}\" Age: \"${first.age}\". Height: \"${first.height}\". Weight: \"${first.weight}\"")
    println("2. Name: \"${twice.name}\". Age: \"${twice.age}\". Height: \"${twice.height}\". Weight: \"${twice.weight}\"")


}