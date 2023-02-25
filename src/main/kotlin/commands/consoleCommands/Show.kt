package commands.consoleCommands

import basicClasses.SpaceMarine
import utils.CollectionManager
import java.util.*

/**
 * Show
 *
 * Prints all elements of the collection
 *
 * @property collection
 * @constructor Create command Show
 */
class Show(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Prints all elements of the collection"
    }

    /**
     * Calls [CollectionManager.show]
     */
    override fun execute(argument:String, sc: Scanner): String {
        return collection.show()
    }

}