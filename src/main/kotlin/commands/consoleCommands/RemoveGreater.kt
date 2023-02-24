package commands.consoleCommands

import exceptions.SpaceMarineNotFound
import utils.CollectionManager
import java.util.Scanner

/**
 * Remove greater
 *
 * Deletes from collection all elements greater than provided
 *
 * @property collection
 * @constructor Create command Remove greater
 */
class RemoveGreater (private val collection: CollectionManager) : Command() {
    override fun getInfo(): String {
        return "Deletes from collection all elements greater than provided"
    }

    /**
     * Removes all elements greater than element with id equal to [argument]
     * Prints the amount of Space Marines deleted
     * @param argument id of element to compare
     */
    override fun execute(argument:String, sc: Scanner): String {
        return try {
            val id = argument.trim().toLong()

            if (collection.getByID(id) == null)
                throw SpaceMarineNotFound("No element with id == $id was found\n")

            else {
                val amount: Int = collection.removeGreater(collection.getByID(id)!!)

                "$amount Space Marines have been deleted\n"
            }
        } catch (e: Exception) {
            e.message.toString()
        }
    }
}