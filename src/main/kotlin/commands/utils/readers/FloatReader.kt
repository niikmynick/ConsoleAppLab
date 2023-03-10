package commands.utils.readers

import basicClasses.SpaceMarine
import utils.InputManager
import utils.OutputManager
import java.util.Scanner

/**
 * Float reader
 *
 * Class containing readers for [SpaceMarine.health]
 *
 * @constructor Create Health reader
 */
class FloatReader(private val outputManager: OutputManager, private val inputManager: InputManager) {
    /**
     * Reads and gives a valid value
     * @return value
     */
    fun read(message: String, canBeNull: Boolean): Float? {
        outputManager.println(message)

        var value = 0F

        do {
            val input = inputManager.read()

            if (input == "\\null") {
                if (canBeNull) {
                    return null
                } else {
                    outputManager.println("This field can not be null")
                }

            } else {
                try {
                    value = input.trim().toFloat()
                } catch (e:Exception) {
                    outputManager.println("This field should be Float-type")
                    continue
                }
            }

            if (value <= 0) {
                outputManager.println("This field cannot be lower than zero")
            }

        } while (value <= 0)

        return value
    }
}