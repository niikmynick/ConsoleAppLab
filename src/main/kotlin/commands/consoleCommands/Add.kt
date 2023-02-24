package commands.consoleCommands

import utils.CollectionManager
import utils.Creator
import java.util.Scanner

/**
 * Add
 * 
 * Adds a new element into the collection
 * 
 * @property collection
 * @constructor Create command Add
 */
class Add (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Adds a new element into the collection")
    }
    /**
     * Creates a Space Marine and adds it into the collection
     * @param sc Is given to creator
     */
    override fun execute(argument:String, sc:Scanner) {
        val spaceMarine = Creator().createSpaceMarine(sc)
        val flag: Boolean = collection.add(spaceMarine)
        if (flag) {
            println("Space Marine ${spaceMarine.getName()} has been created and added to the list")
        } else {
            println("Something went wrong ...\nSpace Marine ${spaceMarine.getName()} has not been added to the list")
        }
    }
}