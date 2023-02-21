package commands.consoleCommands

import utils.CollectionManager

/**
 * Command info: Prints info about the collection (type, creation date, amount of elements)
 * @param collection Current collection
 * @property info Has info about command
 */
class Info (private val collection: CollectionManager) : Command() {
    override val info: String = "Prints info about the collection (type, creation date, amount of elements)"

    override fun execute(argument:String) {
        println(collection.info())
    }

}