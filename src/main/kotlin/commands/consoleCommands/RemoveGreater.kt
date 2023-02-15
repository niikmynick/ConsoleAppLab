package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class RemoveGreater : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        val spaceMarine = Creator().createSpaceMarine()
        val amount : Int = CollectionManager().removeGreater(spaceMarine)
        println("Have been deleted $amount Space Marines")
    }
}