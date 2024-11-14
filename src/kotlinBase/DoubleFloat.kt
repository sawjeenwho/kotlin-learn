package kotlinBase

fun main() {
    val r = readln().toDouble()
    val p = 3.14
    var d = 0.0
    var lengthCircle = 0.0
    var s = 0.0


    d = 2 * r
    lengthCircle = d * p
    s = p * (r * r)

    println("Радиус: $r\nДлина окружности: $lengthCircle\nПлощадь круга: $s")


}