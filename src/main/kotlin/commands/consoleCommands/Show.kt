package commands.consoleCommands

import utils.CollectionManager

/**
 * Show
 *
 * @property collection
 * @constructor Create command Show
 */
class Show (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Prints all elements of the collection")
    }

    override fun execute(argument:String) {
        collection.show()
    }

}