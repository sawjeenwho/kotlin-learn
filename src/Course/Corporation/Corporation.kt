package Course.Corporation

fun main() {
//    val assistant = WorkersRepository.findAssistant()
//    assistant?.printInfo()
//
//    val director = WorkersRepository.findDirector()
//    director?.printInfo()
//    if (assistant != null) {
//        director?.takeCoffe(assistant)
//    }


    val list = listOf(1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9).toMutableList()
    list.removeIf { it == 5 }
    println(list)


}