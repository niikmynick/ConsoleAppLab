package utils

import java.util.*

/**
 * Contains a list of strings that are given to any command
 * @property inputList List that contains input
 * @property cur Index of the string to be given
 */
class InputManager {
    private val inputList = ArrayList<String>()
    private var cur: Int = 0

    /**
     * Gives string from [inputList] with index [cur]
     * If cur is out of bound, a string is requested from standard input
     * @return A string from [inputList] list or from standard input
     */
    fun nextLine(): String {
        val line: String
        try {
            line = inputList[cur]
            cur++
        } catch (e:Exception) {
            addLines(Scanner(System.`in`).nextLine())
            return nextLine()
        }
        return line
    }

    /**
     * Receives a string and adds it into [inputList] separated with a newline
     */
    fun addLines(string: String) {
        val lines = string.split("\\R".toRegex())
        for (line in lines) {
            inputList.add(line)
        }
    }

    /**
     * Receives a collection of strings and adds its elements to [inputList]
     */
    fun addLines(list: Collection<String>) {
        for (line in list) {
            inputList.add(line)
        }
    }

    /**
     * @return true if [inputList] contains an element with [cur] index
     */
    fun hasNextLine(): Boolean {
        return try {
            inputList[cur]
            true
        } catch (e:Exception) {
            false
        }
    }
}