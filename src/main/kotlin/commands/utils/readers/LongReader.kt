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
            var value: Long = 0

            while (value !in a..b) {
                try {
                    value = scanner.nextLine().trim().toLong()

                    if (value <= a) {
                        println("This field cannot be lower than $a")
                    }
                    if (value > b) {
                        println("This field cannot be larger than $b")
                    }

                    value = scanner.nextLine().trim().toLong()
                } catch (e: Exception) {
                    println("This value should be Long-type")
                    continue
                }
            }
            return value
        }
    }
}