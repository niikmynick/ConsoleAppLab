package commands.consoleCommands

import exceptions.SpaceMarineNotFound
import utils.CollectionManager
import java.util.*

/**
 * Command remove_by_id: Deletes the element with the provided id
 * @param collection Current collection
 * @property info Has info about command
 */
class RemoveID (private val collection: CollectionManager) : Command() {
    override val info: String = "Deletes the element with the provided id (remove_by_id {element.id})"

    /**
     * Deletes element with id equal to provided in argument
     * @param argument id of the element to delete
     */
    override fun execute(argument:String, sc: Scanner) {
        try {
            val id = argument.trim().toLong()
            if (collection.getByID(id) != null) {
                val name = collection.getByID(id)!!.getName()
                collection.removeID(id)
                println("Space Marine $name has been deleted")
            } else throw SpaceMarineNotFound("No element with Id=$id was found")
        } catch (e: Exception) {
            println("No element with Id=${argument.trim()} was found")
        }
    }
}