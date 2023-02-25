package commands.consoleCommands

import basicClasses.SpaceMarine
import java.util.*

/**
 * Remove i d
 *
 * Deletes the element with the provided id
 *
 * @property collection
 * @constructor Create command remove_id
 */
class RemoveID(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Deletes the element with the provided id"
    }

    /**
     * Deletes element with id equal to provided in argument
     * @param argument id of the element to delete
     */
    override fun execute(argument:String, sc: Scanner): String {
        return try {
            val id = argument.trim().toLong()
            collection.removeID(id)
        } catch (e: Exception) {
            e.message.toString()
        }
    }
}