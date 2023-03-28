package commands.utils.readers

import utils.InputManager
import utils.OutputManager

class IntReader(private val outputManager: OutputManager, private val inputManager: InputManager) {
    /**
     * Reads and gives a valid value
     * @return value
     */
    fun read(message: String): Int {
        outputManager.println(message)

        var input = inputManager.read()

        while (input.toIntOrNull() == null) {
            outputManager.println("This field must be integer")
            input = inputManager.read()
        }

        return input.toInt()
    }
}