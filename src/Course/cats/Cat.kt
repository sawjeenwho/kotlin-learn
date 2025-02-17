package Course.cats

class Cat(val name: String): CatsFamily() {
fun playWithMouse() {
    println("Cat is playing with mouse...")
}

    override fun eat() {
        println("Eat whiskas...")
    }
}