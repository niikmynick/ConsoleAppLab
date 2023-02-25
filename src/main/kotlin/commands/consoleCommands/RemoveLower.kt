package commands.consoleCommands

import basicClasses.SpaceMarine
import exceptions.SpaceMarineNotFound
import java.util.*

/**
 * Remove lower
 *
 * Deletes from collection all elements lower than provided
 *
 * @property collection
 * @constructor Create command Remove lower
 */
class RemoveLower(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Deletes from collection all elements lower than provided"
    }

    /**
     * Removes all elements lower than element with id equal to argument
     * Prints the amount of Space Marines deleted
     * @param argument id of element to compare
     */
    override fun execute(argument:String, sc: Scanner): String {
        return try {
            val id = sc.nextLine().trim().toLong()

            if (collection.getByID(id) == null)
                throw SpaceMarineNotFound("No element with id == $id was found\n")

            else {
                val amount : Int = collection.removeLower(collection.getByID(id)!!)

                "$amount Space Marines have been deleted\n"
            }
        } catch (e: Exception) {
            e.message.toString()
        }

    }
}