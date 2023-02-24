package commands.consoleCommands

import exceptions.SpaceMarineNotFound
import utils.CollectionManager
import java.util.Scanner

/**
 * Remove i d
 *
 * Deletes the element with the provided id
 *
 * @property collection
 * @constructor Create command remove_id
 */
class RemoveID (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Deletes the element with the provided id")
    }

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