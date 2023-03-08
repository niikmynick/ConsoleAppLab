package commands.utils.readers

import utils.InputManager

class DoubleReader {
    companion object {
        /**
         * Reads and gives a valid value
         * @return value
         */
        fun read(message: String, inputManager: InputManager): Double {
            //val scanner = Scanner(System.`in`)
            println(message)

            var input = inputManager.nextLine()

            while (input.toDoubleOrNull() == null) {
                println("This field must be double")
                input = inputManager.nextLine()
            }

            return input.toDouble()
        }
    }
}