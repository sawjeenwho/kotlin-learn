package Course.cats

fun main() {
    val cat = Cat("Boris")
    val lion = Lion(16)
    val catsFamily = listOf<CatsFamily>(cat,lion)
    for (cat in catsFamily){
        cat.eat()
    }

}