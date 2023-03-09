package commands.utils.readers

import basicClasses.SpaceMarine
import java.util.Scanner

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
        fun read(message: String) : Boolean {
            val scanner = Scanner(System.`in`)
            println(message)

            var loyalty: Boolean? = null
            do {
                try {
                    loyalty = scanner.nextLine().trim().lowercase().toBooleanStrict()
                } catch (e: Exception) {
                    println("You need to enter Boolean-type value of loyalty: ")
                }
            } while (loyalty == null)

            return loyalty
        }
    }
}