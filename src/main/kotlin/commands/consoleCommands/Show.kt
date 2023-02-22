package commands.consoleCommands

import utils.CollectionManager
import java.util.*

/**
 * Command show: Prints all elements of the collection
 * @param collection Current collection
 * @property info Has info about command
 */
class Show (private val collection: CollectionManager) : Command() {
    override val info: String = "Prints all elements of the collection"

    /**
     * Calls [CollectionManager.show]
     */
    override fun execute(argument:String, sc: Scanner) {
        collection.show()
    }

}