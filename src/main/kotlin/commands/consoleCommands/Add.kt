package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class Add (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Adds a new element into the collection")
    }

    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine()
        collection.add(spaceMarine)
        println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
    }
}