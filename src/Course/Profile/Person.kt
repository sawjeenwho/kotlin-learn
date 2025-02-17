package Course.Profile

data class Person(
    val name: String,
    val lastName: String,
    val height: Int,
    val weight: Int
) {
    val fullName: String
        get() = "$name $lastName"


    var age = 0
        set(value) {
            if (value < field) {
                println("The age can only be increased...")
            } else {
                field = value
            }
        }
        get() {
            println("It's not decent to ask about age!")
            return field
        }

    fun sayHello() {
        println("Hello! My name is $name")
    }

    fun printInfo() {
        println(this)
    }

    fun run() {
        repeat(10) {
            println("Im running")
        }
    }

}