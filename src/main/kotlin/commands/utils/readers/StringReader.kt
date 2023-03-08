package commands.utils.readers

import utils.InputManager

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
        fun read(message: String, inputManager: InputManager): String {
            //val scanner = Scanner(System.`in`)
            println(message)

            var value:String = inputManager.nextLine().trim()

            while (value.isEmpty()) {
                println("This field can not be empty")
                println(message)

                value = inputManager.nextLine().trim()
            }

            return value
        }
    }
}
