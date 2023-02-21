package commands.consoleCommands

import utils.CollectionManager

/**
 * Command remove_lower: Deletes from collection all elements lower than provided
 * @param collection Current collection
 * @property info Has info about command
 */
class RemoveLower (private val collection: CollectionManager) : Command() {
    override val info: String = "Deletes from collection all elements lower than provided (remove_lower {element.id})"

    /**
    * Removes all elements lower than element with id equal to [argument]
    * @param argument id of element to compare
    */
    override fun execute(argument:String) {
        try {
            val id = readln().trim().toLong()
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