package commands.consoleCommands

import utils.CollectionManager
import utils.Creator


/**
 * Command add: Adds a new element into the collection
 * @param collection Current collection
 * @property info Has info about command
 */
class Add (private val collection: CollectionManager) : Command() {
    override val info = "Adds a new element into the collection"

    /**
     * todo
     */
    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine()
        collection.add(spaceMarine)
        println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
    }
}