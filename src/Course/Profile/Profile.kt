package Course.Profile

fun main() {
    val person1 = Person("John", "Smith", 180, 90)
    val person2 = Person("John", "Smith", 180, 90)
    val person3 = person1.copy()
    val people = setOf(person1, person2, person3)
    for (person in people) {
        println(person)
    }
}