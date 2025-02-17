package Course.Files

import java.io.File

fun main() {
    val file = File("todo_list.txt")
    val operationCode = FileOperationCode.entries

    while (true){
        print("Enter")
        for((index, code) in operationCode.withIndex()) {
            print(" $index - ${code.title}")
            if (index < operationCode.size -1 ) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val userIndex = readln().toInt()
        val operationIndex = operationCode[userIndex]
        when(operationIndex) {
            FileOperationCode.EXIT -> break
            FileOperationCode.ADD_NEW_TODO -> {
                print("add todo: ")
                val todo = readln()
                file.appendText("$todo\n")
            }
            FileOperationCode.READ_TODO -> {
                val contents = file.readText().trim()
                val items = contents.split("\n")
                for ((index, item) in items.withIndex()) {
                    println("$index - $item")
                }
            }
        }
    }

}