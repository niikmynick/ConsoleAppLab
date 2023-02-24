package commands.consoleCommands

import utils.CollectionManager
import java.util.Scanner

/**
 * Show
 *
 * Prints all elements of the collection
 *
 * @property collection
 * @constructor Create command Show
 */
class Show (private val collection: CollectionManager) : Command() {
    override fun getInfo(): String {
        return "Prints all elements of the collection"
    }

    /**
     * Calls [CollectionManager.show]
     */
    override fun execute(argument:String, sc: Scanner) {
        collection.show()
    }

}