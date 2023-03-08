package commands.utils.readers

import java.util.*

class LongReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String, a:Long, b:Long): Long {
            val scanner = Scanner(System.`in`)
            println(message)

            var value:Long = scanner.nextLine().trim().toLong()

            while (value !in a..b) {
                if (value <= 0) {
                    println("This field cannot be lower than zero")
                }
                if (value > 1000) {
                    println("This field cannot be larger than 1000")
                }

                value = scanner.nextLine().trim().toLong()
            }

            return value
        }
    }
}