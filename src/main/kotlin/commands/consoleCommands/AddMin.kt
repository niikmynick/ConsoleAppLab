package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

/**
 * Add min
 *
 * @property collection
 * @constructor Create command Add min
 */
class AddMin (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Adds a new element into the collection if its value is lower than the lowest element in the collection")
    }

    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine(collection)
        val flag:Boolean = collection.addMin(spaceMarine)
        if (flag) {
            println("Space Marine ${spaceMarine.getName()} has been added to the list")
        } else {
            println("Something went wrong ...\nSpace Marine ${spaceMarine.getName()} has not been added to the list")
        }
    }
}