package Course.cats

class Lion(val pride: Int): CatsFamily() {
    override fun eat() {
        println("Eat antelope...")
    }
}