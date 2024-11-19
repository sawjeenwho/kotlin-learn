package OOP

fun main() {
    val first = Person()
    val second = Person()

    println("Enter 1s name: ")
    val firstName = readln()

    println("Enter 2c name: ")
    val secondName = readln()

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

    first.init(name = firstName, age = firstAge, height = firstHeight, weight = firstWeight)
    second.init(name = secondName, age = secondAge, height = secondHeight, weight = secondWeight)
    first.printInfo()
    second.printInfo()
    first.sayHello()
    second.sayHello()

}