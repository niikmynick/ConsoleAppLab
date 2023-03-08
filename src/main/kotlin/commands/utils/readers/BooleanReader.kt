package commands.utils.readers

import basicClasses.SpaceMarine
import utils.InputManager

/**
 * Boolean reader
 *
 * Class containing readers for [SpaceMarine.loyal]
 *
 * @constructor Create Loyalty reader
 */
class BooleanReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String, inputManager: InputManager) : Boolean {
            //val scanner = Scanner(System.`in`)
            println(message)

            var loyalty: Boolean? = null
            do {
                try {
                    loyalty = inputManager.nextLine().trim().lowercase().toBooleanStrict()
                } catch (e: Exception) {
                    print("You need to enter Boolean-type value of loyalty: ")
                }
            } while (loyalty == null)

            return loyalty
        }
    }
}