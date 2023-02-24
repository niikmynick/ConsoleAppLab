package commands.consoleCommands

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
    override fun writeInfo() {
        println("Deletes from collection all elements greater than provided")
    }

    /**
     * Removes all elements greater than element with id equal to [argument]
     * Prints the amount of Space Marines deleted
     * @param argument id of element to compare
     */
    override fun execute(argument:String, sc: Scanner) {
        try {
            val id = argument.trim().toLong()
            if (collection.getByID(id) == null) println("No element with Id=$id was found")
            else {
                val amount : Int = collection.removeGreater(collection.getByID(id)!!)
                println("$amount Space Marines have been deleted")
            }
        } catch (e: Exception) {
            print("Invalid Long-type value of Id")
        }
    }
}