class Car {
    var brand = ""
    var model = ""
    var enginePower = 0
    var bodyColor = ""

    fun init(brand: String, model: String, enginePower: Int, bodyColor: String) {
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    } //добавьте метод init()

    fun drive() {
        //измените метод
        if (enginePower >= 120) {
            println("Еду быстро, но недалеко на $brand $model")
        } else if (enginePower < 120){
            println("Еду далеко, но небыстро на $brand $model")
        }
    }
}

fun task() {
    val car = Car()
    val carInfo = readln().split(" ")
    val brand = carInfo[0]
    val model = carInfo[1]
    val enginePower = carInfo[2].toInt()
    val bodyColor = carInfo[3]

    car.init(brand, model, enginePower, bodyColor)
    car.drive()
    //создайте здесь экземпляр Car и вызовите у него методы init() и drive()
}