package Course.Corporation

import Course.Corporation.products.Enums.PositionType

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    open val salary: Int = 15000,
    val positionType: PositionType
) {



     abstract fun copy(
        id: Int = this.id,
        name: String = this.name,
        salary: Int = this.salary,
        age: Int = this.age,
        positionType: PositionType = this.positionType
    ): Worker
    abstract fun work()
    open fun printInfo() {
        println(this)
    }

}