package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class Add : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args:Any) {
        val spaceMarine = Creator().createSpaceMarine()
        CollectionManager().add(spaceMarine)
        println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
    }
}