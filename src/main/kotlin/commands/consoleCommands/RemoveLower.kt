package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class RemoveLower (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Удаляет из коллекции все элементы, меньшие, чем заданный")
    }

    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine()
        val amount : Int = collection.removeLower(spaceMarine)
        println("Have been deleted $amount Space Marines")
    }
}