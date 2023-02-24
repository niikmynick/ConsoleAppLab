package commands.consoleCommands

import utils.CollectionManager
import java.util.Scanner

/**
 * Info
 *
 * Prints info about the collection (type, creation date, amount of elements)
 *
 * @property collection
 * @constructor Create command Info
 */
class Info (private val collection: CollectionManager) : Command() {
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