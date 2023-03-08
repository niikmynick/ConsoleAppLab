package commands.utils.readers

import java.util.*

class DoubleReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String): Double {
            val scanner = Scanner(System.`in`)
            println(message)

            var input = scanner.nextLine()

            while (input.toDoubleOrNull() == null) {
                println("This field must be double")
                input = scanner.nextLine()
            }

            return input.toDouble()
        }
    }
}