package commands.consoleCommands

import utils.CollectionManager
import utils.Creator
import java.util.Scanner

/**
 * Add
 *
 * @property collection
 * @constructor Create empty Add
 */
class Add (private val collection: CollectionManager) : Command() {
    override fun getInfo(): String {
        return "Adds a new element into the collection"
    }
    /**
     * Creates a Space Marine and adds it into the collection
     * @param sc Is given to creator
     */
    override fun execute(argument:String, sc:Scanner): String {
        val spaceMarine = Creator.createSpaceMarine(sc)
        val flag: Boolean = collection.add(spaceMarine)

        return if (flag) {
            "Space Marine ${spaceMarine.getName()} has been created and added to the list\n"
        } else {
            "Something went wrong ...\nSpace Marine ${spaceMarine.getName()} has not been added to the list\n"
        }
    }
}