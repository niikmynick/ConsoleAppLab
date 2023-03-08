package utils

import java.util.*

class InputManager {
    private val input = ArrayList<String>()
    private var cur: Int = 0
    fun nextLine(): String {
        val line: String
        try {
            line = input[cur]
            cur++
        } catch (e:Exception) {
            addLines(Scanner(System.`in`).nextLine())
            return nextLine()
        }
        return line
    }

    fun addLines(string: String) {
        val lines = string.split("\\R".toRegex())
        for (line in lines) {
            input.add(line)
        }
    }
    fun hasNextLine(): Boolean {
        return try {
            input[cur]
            true
        } catch (e:Exception) {
            false
        }
    }
}