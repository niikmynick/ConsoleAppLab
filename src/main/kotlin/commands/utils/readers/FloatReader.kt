package commands.utils.readers

import basicClasses.SpaceMarine
import java.util.Scanner

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
        fun read(message: String, canBeNull: Boolean): Float? {
            val scanner = Scanner(System.`in`)
            println(message)

            var value = 0F

            do {
                val input = scanner.nextLine()

                if (input == "\\null") {
                    if (canBeNull) {
                        return null
                    } else {
                        println("This field can not be null")
                    }

                } else {
                    value = input.trim().toFloat()
                }

                if (value <= 0) {
                    println("This field cannot be lower than zero")
                }

            } while (value <= 0)

            return value
        }
    }
}