//fun main() {
//    print("Enter password: ")
//    val password = readln().toCharArray()
//    var containsLatter = false
//    var containsDigit = false
//    var containsSpecialSymbol = false
//
//    for (symbol in password) {
//        if (symbol.isLetter()) {
//            containsLatter = true
//        }
//        if (symbol.isDigit()) {
//            containsDigit = true
//        }
//        if (!symbol.isLetterOrDigit()) {
//            containsSpecialSymbol = true
//        }
//    }
//    if (containsDigit && containsDigit && containsSpecialSymbol && password.size >= 8) {
//        println("Password is valid")
//    } else {
//        println("Password is NOT validate")
//    }
//}
//
//
//// 1 буква 1 цифра 1 символ 8 цифр


fun main() {
    val password = readln().toCharArray()
    var mainSymbol = false


    for (symbol in password){
        if (symbol == 'Ъ'){
            mainSymbol = true
        }
    }
    if (!mainSymbol){
        println("Опс! В вашем пароле кое-чего не хватает.")
    }else {
        println("У вас идеальный пароль!")
    }

}