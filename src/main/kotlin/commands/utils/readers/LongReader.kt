package commands.utils.readers

import utils.InputManager
import utils.OutputManager
import java.util.*

class LongReader(private val outputManager: OutputManager, private val inputManager: InputManager) {
    /**
     * Reads and gives a valid value
     * @return value
     */
    fun read(message: String, a:Long, b:Long): Long {
        outputManager.println(message)
        var value: Long = -1

        while (value !in a..b) {
            try {
                value = inputManager.read().trim().toLong()

                if (value <= a) {
                    outputManager.println("This field cannot be lower than $a")
                }
                if (value > b) {
                    outputManager.println("This field cannot be larger than $b")
                }

            } catch (e: Exception) {
                outputManager.println("This value should be Long-type")
                continue
            }
        }
        return value
    }
}