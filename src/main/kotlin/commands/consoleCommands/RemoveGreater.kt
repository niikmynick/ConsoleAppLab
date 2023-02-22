package commands.consoleCommands

import utils.CollectionManager
import java.util.*

/**
 * Command remove_greater: Deletes from collection all elements greater than provided
 * @param collection Current collection
 * @property info Has info about command
 */
class RemoveGreater (private val collection: CollectionManager) : Command() {
    override val info: String = "Deletes from collection all elements greater than provided (remove_greater {element.id})"

    /**
     * Removes all elements greater than element with id equal to [argument]
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