package commands.utils.readers

import utils.InputManager
import utils.OutputManager

/**
 * Enum reader
 *
 * @constructor Create  Enum reader
 */
class EnumReader(val outputManager: OutputManager, val inputManager: InputManager) {
    inline fun <reified T : Enum<T>> enumContains(name: String): Boolean {
        return enumValues<T>().any { it.name == name }
    }

    inline fun <reified T : Enum<T>> read(message: String, canBeNull:Boolean): T? {
        outputManager.println(message)
        for (item in enumValues<T>()) {
            outputManager.println(item.toString())
        }

        var value = inputManager.read().trim().uppercase()

        while (!enumContains<T>(value)) {
            value = if (value.isEmpty()) {
                outputManager.println("his field can not be empty. Try again: ")
                inputManager.read().trim().uppercase()
            } else if (value == "\\null") {
                if (canBeNull) {
                    return null
                } else {
                    outputManager.println("This field can not be null. Try again: ")
                    inputManager.read().trim().uppercase()
                }
            } else {
                outputManager.println("The entered weapon type doesn't exist. Try again: ")
                inputManager.read().trim().uppercase()
            }
        }
        return enumValueOf<T>(value)
    }
}
