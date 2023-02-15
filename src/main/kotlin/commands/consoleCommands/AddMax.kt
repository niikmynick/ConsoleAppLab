package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class AddMax : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        val spaceMarine = Creator().createSpaceMarine()
        val flag:Boolean = CollectionManager().addMax(spaceMarine)
        if (flag) {
            println("Space Marine ${spaceMarine.getName()} has been added to list")
        } else {
            println("Space Marine ${spaceMarine.getName()} has not been added to list")
        }
    }
}