fun main() {
    val numbers = 0..1000 step 2
    val userNumber = readln().toInt()

    for (number in numbers){
        if (userNumber in numbers) {
            println("Входит в диапазон")
            break
        }else {
            println("Не входит в диапазаон")
            break
        }
    }
}