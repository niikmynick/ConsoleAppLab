package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class RemoveGreater : Command() {
    override fun writeInfo() {
        println("Удаляет из коллекции все элементы, превышающие заданный")
    }

    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine()
        val amount : Int = CollectionManager().removeGreater(spaceMarine)
        println("Have been deleted $amount Space Marines")
    }
}