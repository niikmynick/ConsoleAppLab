package commands.utils.readers

import basicClasses.SpaceMarine
import utils.InputManager

/**
 * Float reader
 *
 * Class containing readers for [SpaceMarine.health]
 *
 * @constructor Create Health reader
 */
class FloatReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String, canBeNull: Boolean, inputManager: InputManager): Float? {
            //val scanner = Scanner(System.`in`)
            println(message)

            var value = 0F

            do {
                val input = inputManager.nextLine()

                if (input == "\\null") {
                    if (canBeNull) {
                        return null
                    } else {
                        println("This field can not be null")
                    }

                } else {
                    try {
                        value = input.trim().toFloat()
                    } catch (e:Exception) {
                        print("You need to enter a Float-type value: ")
                    }

                }

                if (value <= 0) {
                    println("This field cannot be lower than zero")
                }

            } while (value <= 0)

            return value
        }
    }
}