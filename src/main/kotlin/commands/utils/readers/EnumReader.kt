package commands.utils.readers

import java.util.*

/**
 * Enum reader
 *
 * @constructor Create  Enum reader
 */
class EnumReader {
    companion object {
        inline fun <reified T : Enum<T>> enumContains(name: String): Boolean {
            return enumValues<T>().any { it.name == name }
        }

        inline fun <reified T : Enum<T>> read(message: String, canBeNull:Boolean): T? {
            println(message)
            val scanner = Scanner(System.`in`)

            for (item in enumValues<T>()) {
                println(item)
            }

            var value = scanner.nextLine().trim().uppercase()

            while (!enumContains<T>(value)) {
                if (value.isEmpty()) {
                    println("his field can not be empty. Try again: ")
                    value = scanner.nextLine().trim().uppercase()
                } else if (value == "\\null") {
                    if (canBeNull) {
                        return null
                    } else {
                        println("This field can not be null. Try again: ")
                        value = scanner.nextLine().trim().uppercase()
                    }
                } else {
                    println("The entered weapon type doesn't exist. Try again: ")
                    value = scanner.nextLine().trim().uppercase()
                }
            }
            return enumValueOf<T>(value)
        }
    }
}