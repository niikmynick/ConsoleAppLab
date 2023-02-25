package commands.consoleCommands

import basicClasses.SpaceMarine
import utils.CollectionManager
import java.util.*

/**
 * Info
 *
 * Prints info about the collection (type, creation date, amount of elements)
 *
 * @property collection
 * @constructor Create command Info
 */
class Info(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Prints info about the collection (type, creation date, amount of elements)"
    }

    /**
     * Calls and prints [CollectionManager.info]
     */
    override fun execute(argument:String, sc: Scanner): String {
        return collection.info()
    }

}