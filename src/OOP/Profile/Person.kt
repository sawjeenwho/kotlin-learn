package OOP.Profile

class Person(
    private val name: String,
     var lastName: String,
    private val height: Int,
    private val weight: Int
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
        println("Name: \"$name\" Age: \"$age\". Height: \"$height\". Weight: \"$weight\"")
    }

    fun run() {
        repeat(10){
            println("Im running")
        }
    }
}