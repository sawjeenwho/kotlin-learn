package OOP

fun main() {
    println("Enter name: ")
    val name = readln()
    println("Enter brand: ")
    val brand = readln()
    println("Enter size: ")
    val size = readln().toFloat()
    println("Enter price: ")
    val price = readln().toInt()

    val productCard = ProductCard()
    productCard.init(name = name, brand = brand, size = size, price = price)
    productCard.printInfo()

}
