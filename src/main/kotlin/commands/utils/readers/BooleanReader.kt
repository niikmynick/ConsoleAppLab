package commands.utils.readers

import basicClasses.SpaceMarine
import utils.InputManager
import utils.OutputManager
import java.util.Scanner

/**
 * Boolean reader
 *
 * Class containing readers for [SpaceMarine.loyal]
 *
 * @constructor Create Loyalty reader
 */
class BooleanReader(private val outputManager: OutputManager, private val inputManager: InputManager) {
    /**
     * Reads and gives a valid value
     * @return value
     */
    fun read(message: String) : Boolean {
        outputManager.println(message)

        var loyalty: Boolean? = null
        do {
            try {
                loyalty = inputManager.read().trim().lowercase().toBooleanStrict()
            } catch (e: Exception) {
                outputManager.println("You need to enter Boolean-type value of loyalty: ")
            }
        } while (loyalty == null)

        return loyalty
    }
}