import kotlin.random.Random

fun main() {
    val correctNumber = Random.nextInt(100)

    var win = false

    while (!win) {
        println("Введи любое число от 0 до 100: ")
        val number = readln().toInt()
        if (number < correctNumber) {
            println("Ваше число меньше")
        } else if (number > correctNumber) {
            println("Ваше число больше")
        } else {
            win = true
            println("Ты угадал")
        }
    }
}