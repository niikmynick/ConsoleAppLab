package commands.consoleCommands

import utils.CollectionManager

/**
 * Command show: Prints all elements of the collection
 * @param collection Current collection
 * @property info Has info about command
 */
class Show (private val collection: CollectionManager) : Command() {
    override val info: String = "Prints all elements of the collection"

    override fun execute(argument:String) {
        collection.show()
    }

}