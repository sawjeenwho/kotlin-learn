package kotlinBase

fun main() {

    println("Ваш возраст?: ")
    var age = readln().toInt()
    repeat(age){
        println("С Днем Рождения")
    }
}