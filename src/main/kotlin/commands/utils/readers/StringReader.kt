package commands.utils.readers

import utils.InputManager
import utils.OutputManager

/**
 * String reader
 *
 * Class containing readers for string
 *
 * @constructor Create reader
 */
class StringReader(private val outputManager: OutputManager, private val inputManager: InputManager) {
    /**
     * Reads and gives a valid value
     * @return value
     */
    fun read(message: String): String {
        outputManager.println(message)

        var value:String = inputManager.read().trim()

        while (value.isEmpty()) {
            outputManager.println("This field can not be empty")
            outputManager.println(message)

            value = inputManager.read().trim()
        }

        return value
    }
}
