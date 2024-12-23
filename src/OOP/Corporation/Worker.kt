package OOP.Corporation

import OOP.Corporation.products.Enums.PositionType

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    private var salary: Int = 15000,
    val positionType: PositionType
) {


    fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("The new salary is too small... ")
        } else {
            this.salary = salary
        }
    }
    fun getSalary() = this.salary

    abstract fun work()
    open fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return ("id: $id, name - $name, age - $age Position: ${positionType.title}, Salary: $salary")
    }

}