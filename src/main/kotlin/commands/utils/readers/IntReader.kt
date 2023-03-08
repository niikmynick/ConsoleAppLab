package commands.utils.readers

import utils.InputManager

class IntReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String, inputManager: InputManager): Int {
            //val scanner = Scanner(System.`in`)
            println(message)

            var input = inputManager.nextLine()

            while (input.toIntOrNull() == null) {
                println("This field must be integer")
                input = inputManager.nextLine()
            }

            return input.toInt()
        }
    }
}