package commands.consoleCommands

import utils.CollectionManager
import java.util.Scanner

/**
 * Update
 *
 * Update values of the element with the provided id
 *
 * @property collection
 * @constructor Create command Update
 */
class Update (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Updates values of the element with the provided id")
    }

    /**
     * Calls [CollectionManager.update] with provided id equal to [argument]
     * @param argument id of the element to update
     * @param sc Given to [CollectionManager.update]
     */
    override fun execute(argument:String, sc: Scanner) {
        try {
            val id = argument.trim().toLong()
            collection.update(id, sc)
        } catch (e: Exception) {
            print("Invalid Long-type value of Id")
        }
    }
}