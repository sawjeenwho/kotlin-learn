package kotlinBase

fun main() {
    val temperature = readln().toInt()
    val hot = temperature > 25
    val cold = temperature < 20
    if (hot) {
        println("AC is on")
    } else if (cold) {
        println("AC is off")
    } else {
        println("AC is idle")
    }
}