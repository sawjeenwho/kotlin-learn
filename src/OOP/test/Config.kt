package OOP.test

class Config {
    var timeout = 30
        set(value) {
            if (value > 1 && value < 300) {
                field = value
            } else {
                print(
                    "Ошибка: Время ожидания должно быть в диапазоне от 1 до 300 секунд. " +
                            "Установлено значение по умолчанию."
                )
                field = 30
            }
        }
    var maxRetries = 3
        set(value) {
            if (value > 0) {
                field = value
            } else {
                println(
                    "Ошибка: Максимальное количество повторных попыток не может быть отрицательным. " +
                            "Установлено значение по умолчанию."
                )
                field = 3
            }
        }
    var loggingLevel = LogLevel.INFO
        set(value) {
            if (value != LogLevel.TRACE && value != LogLevel.FATAL) {
                field = value
            } else {
                field = loggingLevel
                println("Ошибка: Уровень $value недоступен.")
            }
        }

    val isDebugMode: Boolean
        get() {
            if (loggingLevel == LogLevel.DEBUG) {
                return true
            } else {
                return false
            }
        }
    val isProductionMode: Boolean
        get() {
            if (loggingLevel == LogLevel.ERROR) {
                return true
            } else {
                return false
            }
        }
    fun printConfig() {
        println("Время ожидания: $timeout секунд\n" +
                "Максимальное количество повторных попыток: $maxRetries\n" +
                "Уровень логирования: $loggingLevel\n" +
                "Режим отладки: $isDebugMode\n" +
                "Режим продакшн: $isProductionMode")
    }
}