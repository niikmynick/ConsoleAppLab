package commands.consoleCommands

import utils.CollectionManager

/**
 * Command update_id: Updates values of the element with the provided id
 * @param collection Current collection
 * @property info Has info about command
 */
class Update (private val collection: CollectionManager) : Command() {
    override val info: String = "Updates values of the element with the provided id (update_id {element.id})"

    /**
     * Calls [CollectionManager.update] with provided id equal to [argument]
     * @param argument id of the element to update
     */
    override fun execute(argument:String) {
        try {
            val id = argument.trim().toLong()
            collection.update(id)
        } catch (e: Exception) {
            print("Invalid Long-type value of Id")
        }
    }
}