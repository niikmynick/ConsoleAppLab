package commands.consoleCommands

import utils.CollectionManager
import utils.Creator
import java.util.*

/**
 * Command add_if_min: Adds a new element into the collection if its value is lower than the lowest element in the collection
 * @param collection Current collection
 * @property info Has info about command
 */
class AddMin (private val collection: CollectionManager) : Command() {
    override val info: String = "Adds a new element into the collection if its value is lower than the lowest element in the collection"

    /**
     * todo
     */
    override fun execute(argument:String, sc: Scanner) {
        val spaceMarine = Creator().createSpaceMarine(sc)
        val flag:Boolean = collection.addMin(spaceMarine)
        if (flag) {
            println("Space Marine ${spaceMarine.getName()} has been added to list")
        } else {
            println("Space Marine ${spaceMarine.getName()} has not been added to list")
        }
    }
}