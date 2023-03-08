package commands.utils.readers

import basicClasses.SpaceMarine
import java.util.Scanner

/**
 * String reader
 *
 * Class containing readers for string
 *
 * @constructor Create reader
 */
class StringReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String): String {
            val scanner = Scanner(System.`in`)
            println(message)

            var value:String = scanner.nextLine().trim()

            while (value.isEmpty()) {
                println("This field can not be empty")
                println(message)

                value = scanner.nextLine().trim()
            }

            return value
        }
    }
}
