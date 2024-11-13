fun main() {
    var temperature = readln().toInt()
    var airConditionerIsOn = false

    repeat(100) {
        if (temperature > 25) {
            airConditionerIsOn = true
        } else if (temperature < 20){
            airConditionerIsOn = false
        }
        if (airConditionerIsOn) {
            temperature--
        } else {
            temperature++
        }
        println("Current temperature: $temperature")
    }




}