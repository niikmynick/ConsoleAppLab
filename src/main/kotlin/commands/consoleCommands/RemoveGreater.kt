package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class RemoveGreater (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Удаляет из коллекции все элементы, превышающие заданный")
    }

    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine()
        val amount : Int = collection.removeGreater(spaceMarine)
        println("Have been deleted $amount Space Marines")
    }
}