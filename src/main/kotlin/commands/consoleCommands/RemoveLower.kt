package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class RemoveLower : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        val spaceMarine = Creator().createSpaceMarine()
        val amount : Int = CollectionManager().removeLower(spaceMarine)
        println("Have been deleted $amount Space Marines")
    }
}