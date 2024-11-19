package kotlinBase

fun main() {
    val daysOfWeekAsString = "Monday, Thusday, Wednesday, Thursday, Friday, Sartuday, Sunday"
    val daysOfWeek = daysOfWeekAsString.split(", ")
    println(daysOfWeek[0])

}