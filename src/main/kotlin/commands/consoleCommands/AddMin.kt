package commands.consoleCommands

import utils.CollectionManager
import utils.Creator
import java.util.Scanner

/**
 * Add min
 *
 * Adds a new element into the collection if its value is lower than the lowest element in the collection
 *
 * @property collection
 * @constructor Create command Add min
 */
class AddMin (private val collection: CollectionManager) : Command() {
    override fun getInfo(): String {
        return "Adds a new element into the collection if its value is lower than the lowest element in the collection"
    }

    /**
     * Creates a Space Marine and adds it into the collection if its lower than the lowest element in the collection
     * Prints whether the Space Marine was added or not
     * @param sc Is given to creator
     */
    override fun execute(argument:String, sc: Scanner) {
        val spaceMarine = Creator.createSpaceMarine(sc)
        val flag:Boolean = collection.addMin(spaceMarine)
        if (flag) {
            println("Space Marine ${spaceMarine.getName()} has been added to the list")
        } else {
            println("Something went wrong ...\nSpace Marine ${spaceMarine.getName()} has not been added to the list")
        }
    }
}