package commands.utils.readers

import java.util.*

class IntReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String): Int {
            val scanner = Scanner(System.`in`)
            println(message)

            var input = scanner.nextLine()

            while (input.toIntOrNull() == null) {
                println("This field must be integer")
                input = scanner.nextLine()
            }

            return input.toInt()
        }
    }
}