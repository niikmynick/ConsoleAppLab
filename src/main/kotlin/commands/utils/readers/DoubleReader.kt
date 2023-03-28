package commands.utils.readers

import utils.InputManager
import utils.OutputManager

class DoubleReader(private val outputManager: OutputManager, private val inputManager: InputManager) {

    /**
     * Reads and gives a valid value
     * @return value
     */
    fun read(message: String): Double {
        outputManager.println(message)

        var input = inputManager.read()

        while (input.toDoubleOrNull() == null) {
            outputManager.println("This field must be double")
            input = inputManager.read()
        }

        return input.toDouble()
    }
}