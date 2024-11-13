//fun main() {
//    val userNumber = readln().split(" ")
//    var sum = 0
//    for (number in userNumber) {
//        sum += number.toInt()
//    }
//    println(sum)
//}


fun main() {
    println("Введи числа: ")
    val numbers = readln().split(" ")
    var sum = 0

    for (number in numbers) {
        sum += number.toInt()
    }
    println(sum)
}