package OOP.test

fun main() {
    val days = DaysOfWeek.entries
    for (day in days) {
        println("${day.title}")
    }
}