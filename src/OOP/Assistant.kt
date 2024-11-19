package OOP

class Assistant {
    fun bringCoffe(count: Int, type: String) {
        repeat(count){
            println("Get up")
            println("Go to the coffe machine")
            println("Press the \"$type\" button")
            println("Wait for the $type to be prepared")
            println("Bring coffe to the director")
            println("Put coffe on the table")
            println("Return to the workspace")
        }


    }
}