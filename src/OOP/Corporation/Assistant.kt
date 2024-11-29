package OOP.Corporation

class Assistant(
    name: String
): Worker(name) {
    override fun work() {
        println("I am talking on the phone....")
    }

    fun bringCoffee(count: Int = 1, type: String = "Cappuccino"): String {
        repeat(count) {
            println("Get up...")
            println("Go to the coffe machine...")
            println("Press the \"$type\" button...")
            println("Wait for the $type to be prepared...")
            println("Bring coffe to the director...")
            println("Put coffe on the table...")
            println("Return to the workspace...")
        }
        return type
    }
}