//fun main() {
//    print("Enter action: ")
//    val firstNumber = readln().toDouble()
//    println("Enter symbol (* / + -)")
//    val symbol = readln()
//    println("Enter second number: ")
//    val secondNumber = readln().toDouble()
//
//    var result = 0.0
//    if (symbol == "/") {
//        result = firstNumber / secondNumber
//    } else if (symbol == "*") {
//        result = firstNumber * secondNumber
//    } else if (symbol == "+"){
//        result = firstNumber + secondNumber
//    } else if (symbol == "-"){
//        result = firstNumber - secondNumber
//    }
//    println("$firstNumber $symbol $secondNumber = $result")
//}

//fun main() {
//    print("Enter action: ")
//    val action = readln().split(" ")
//
//    var result = when (action[1]) {
//
//        "+" -> action[0].toDouble() + action[2].toInt()
//        "-" -> action[0].toDouble() - action[2].toDouble()
//        "*" -> action[0].toDouble() * action[2].toDouble()
//        "/" -> action[0].toDouble() / action[2].toDouble()
//
//        else -> 0.0
//
//    }
//    println(result)
//}


fun main() {
    print("Enter action: ")
    val action = readln().split(" ")

    val symbol = action[1]
    val firstNumber = action[0].toDouble()
    val secondNumber = action[2].toDouble()

    var result = when(symbol) {
        "+" -> firstNumber + secondNumber
        "-" -> firstNumber - secondNumber
        "*" -> firstNumber * secondNumber
        "/" -> firstNumber / secondNumber
        else -> ""
    }
    println(result)
}