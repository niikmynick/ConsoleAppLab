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

            var value: Long? = null
            do {
                try {
                    value = scanner.nextLine().trim().toLong()
                } catch (e:Exception) {
                    print("You need to enter a Long-type value: ")
                }
                if (value != null) {
                    if (value <= a) {
                        println("This field cannot be lower than $a")
                    }
                    if (value > b) {
                        println("This field cannot be larger than $b")
                    }
                }
            } while (value !in a..b)

            return value!!
        }
    }
}