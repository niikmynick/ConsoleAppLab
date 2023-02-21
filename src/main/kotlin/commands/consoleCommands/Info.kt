package commands.consoleCommands

import utils.CollectionManager

/**
 * Info
 *
 * @property collection
 * @constructor Create command Info
 */
class Info (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Prints info about the collection (type, creation date, amount of elements)")
    }

    override fun execute(argument:String) {
        println(collection.info())
    }

}