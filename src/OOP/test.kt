package OOP

class Car {
    var brand = ""
    var model = ""
    var enginePower = 0
    var bodyColor = ""

    fun drive() {
        println("Еду на автомобиле")
    }

    fun refuel(gas: String, brand: String, quantity: Int) {
        println("Произведена заправка на АЗС \"$gas\"")
        println("Марка бензина: $brand")
        println("Кол-во литров: $quantity")
    }
    // объявите здесь функцию refuel()
}

fun task() {
    val arguments = readln().split(" ")
    val car = Car()
    car.refuel(arguments[0], arguments[1], arguments[2].toInt())
    //создайте здесь экземпляр Car и вызовите у него метод refuel()
}