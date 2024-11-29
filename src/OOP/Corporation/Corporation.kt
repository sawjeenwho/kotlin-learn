package OOP.Corporation

import OOP.Corporation.products.ShoesCard

fun main() {
    val director = Director(name = "Sergey", age = 25)
    val assistant = Assistant(name = "Tanya")
    val consultant = Consultant("Max", 25)
    val accountant = Accountant("Misha")
    val employees = listOf<Worker>(director, assistant, consultant, accountant)
    for (empleyee in employees) {
        empleyee.work()
    }

}