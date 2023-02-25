package commands.consoleCommands

import basicClasses.SpaceMarine
import utils.CollectionManager
import java.util.*

/**
 * Update
 *
 * Update values of the element with the provided id
 *
 * @property collection
 * @constructor Create command Update
 */
class Update(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Updates values of the element with the provided id"
    }

    /**
     * Calls [CollectionManager.update] with provided id equal to [argument]
     * @param argument id of the element to update
     * @param sc Given to [CollectionManager.update]
     */
    override fun execute(argument:String, sc: Scanner): String {
        return try {
            val id = argument.trim().toLong()
            collection.update(id, sc)
        } catch (e: Exception) {
            e.message.toString()
        }
    }
}