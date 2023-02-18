package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class AddMin (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Adds a new element into the collection if its value is lower than the lowest element in the collection")
    }

    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine(collection)
        val flag:Boolean = collection.addMin(spaceMarine)
        if (flag) {
            println("Space Marine ${spaceMarine.getName()} has been added to list")
        } else {
            println("Space Marine ${spaceMarine.getName()} has not been added to list")
        }
    }
}