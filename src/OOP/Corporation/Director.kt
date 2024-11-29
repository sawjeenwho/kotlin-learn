package OOP.Corporation

class Director(
    name: String,
    age: Int,
) : Worker(name, age) {

    override fun work() {
        println("I'm drinking coffee...")
    }

    fun takeCoffe(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("Thank you! ${assistant.name}! The $drinkName is very tasty")
    }

    fun assistantWorkCheck(consultant: Consultant) {
        val count = consultant.serveClient()
        println("Consultan ${consultant.name} serve $count clients. ")
    }
}