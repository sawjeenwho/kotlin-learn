package kotlinBase//fun main() {
//    println("Введите порядковый номер месяца: ")
//    val index = readln().toInt()
//    val mouth = when (index) {
//        1 -> "Январь"
//
//        2 -> "Февраль"
//
//        3 -> "Март"
//
//        4 -> "Апрель"
//
//        5 -> "Май"
//
//        6 -> "Июнь"
//
//        7 -> "Июль"
//
//        8 -> "Август"
//
//        9 -> "Сентябрь"
//
//        10 -> "Октябрь"
//
//        11 -> "Ноябрь"
//
//        12 -> "Декабрь"
//
//        else -> ""
//
//    }
//
//
//
//    if (index in 1..12) {
//        println("Вы ввели порядковый номер: $index\nЕму соответствеует месяц \"$mouth\"")
//    } else {
//        println("Такого месяца не существует")
//    }
//}


fun main() {
    println("Введите название месяца: ")
    val mouthName = readln()

    val mouth = when (mouthName) {
        "Сентябрь", "Октябрь", "Ноябрь" -> "Осень"
        "Декабрь", "Январь", "Февраль" -> "Зима"
        "Март", "Апрель", "Май" -> "Весна"
        "Июнь", "Июль", "Август" -> "Лето"
        else -> ""
    }
 if (mouth == ""){
     println("Такого месяца не существует")
 } else {
     println("Время года $mouth")
 }


}



