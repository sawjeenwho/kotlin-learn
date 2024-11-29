package OOP.cats

fun main() {
    val cat = Cat("Boris")
    val lion = Lion(16)
    println("Cat: ${cat.legsCount}, ${cat.name}\n" +
            "Lion: PrideCount - ${lion.pride}, ${lion.legsCount}")
    cat.playWithMouse()

}