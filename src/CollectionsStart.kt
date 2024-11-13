//fun main() {
//    val month = listOf<Int>(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
//    print("Какой по счету месяц интересует?: ")
//    val index = readln().toInt()
//
//    if (index == 1 || index <= 12) {
//        println(month[index - 1])
//    } else {
//        println("nonono")
//    }
//}

//ДЗ

fun main() {
    val month = listOf("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")
    val index = readln().toInt()

        if (index == 1 || index <= 12) {
        println(month[index - 1])
    } else {
        println("Некорректное значение: $index")
    }
}