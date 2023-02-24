package commands.consoleCommands

import utils.CollectionManager
import java.util.Scanner

/**
 * Remove lower
 *
 * Deletes from collection all elements lower than provided
 *
 * @property collection
 * @constructor Create command Remove lower
 */
class RemoveLower (private val collection: CollectionManager) : Command() {
    override fun getInfo(): String {
        return "Deletes from collection all elements lower than provided"
    }

    /**
     * Removes all elements lower than element with id equal to argument
     * Prints the amount of Space Marines deleted
     * @param argument id of element to compare
     */
    override fun execute(argument:String, sc: Scanner) {
        try {
            val id = sc.nextLine().trim().toLong()
            if (collection.getByID(id) == null) println("No element with Id=$id was found")
            else {
                val amount : Int = collection.removeLower(collection.getByID(id)!!)
                println("$amount Space Marines have been deleted")
            }
        } catch (e: Exception) {
            print("Invalid Long-type value of Id")
        }

    }
}