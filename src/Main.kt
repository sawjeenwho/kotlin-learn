fun main() {
    var carMode = readln().toBoolean()
    val power = readln().toInt()
    var order = 0
    var sum = 0
    var car = ""
    if (power <= 100 && carMode) {
        order = 25
        sum = power * order
        car = "грузовой автомобиль"
    } else if (power > 100 && power <= 150 && carMode) {
        order = 40
        sum = power * order
        car = "грузовой автомобиль"
    } else if (power > 150 && power <= 200 && carMode) {
        order = 50
        sum = power * order
        car = "грузовой автомобиль"
    } else if (power > 200 && power <= 250 && carMode) {
        order = 65
        sum = power * order
        car = "грузовой автомобиль"
    } else if (power > 250 && carMode) {
        order = 85
        sum = power * order
        car = "грузовой автомобиль"
    } else if (power <= 100) {
        order = 10
        sum = power * order
        car = "легковой автомобиль"
    } else if (power > 100 && power <= 150 ) {
        order = 34
        sum = power * order
        car = "легковой автомобиль"
    } else if (power > 150 && power <= 200) {
        order = 49
        sum = power * order
        car = "легковой автомобиль"
    } else if (power > 200 && power <= 250) {
        order = 75
        sum = power * order
        car = "легковой автомобиль"
    } else if (power > 250) {
        order = 150
        sum = power * order
        car = "легковой автомобиль"
    }
    println("Вид ТС: $car\nМощность двигателя: $power л.с.\nНалоговая ставка: $order руб./л.с.\nСумма налога: $sum руб.")
}