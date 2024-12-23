package OOP.Profile

fun main() {

    println("Enter 1s name: ")
    val firstName = readln()

    println("Enter 2c name: ")
    val secondName = readln()

    println("Enter 1s last name: ")
    val firstLastName = readln()

    println("Enter 2s last name: ")
    val secondLastName = readln()


    println("Enter 1c age: ")
    val firstAge = readln().toInt()

    println("Enter 2c age: ")
    val secondAge = readln().toInt()

    println("Enter 1c height: ")
    val firstHeight = readln().toInt()

    println("Enter 2c height: ")
    val secondHeight = readln().toInt()

    println("Enter 1c weight: ")
    val firstWeight = readln().toInt()

    println("Enter 2c weight: ")
    val secondWeight = readln().toInt()

    val first = Person(name = firstName, lastName = firstLastName, height = firstHeight, weight = firstWeight)
    val second = Person(name = secondName, lastName = secondLastName, height = secondHeight, weight = secondWeight)

    println("First: ${first.fullName}, second: ${second.fullName}")
}