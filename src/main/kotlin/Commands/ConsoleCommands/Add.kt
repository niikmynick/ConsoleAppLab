package Commands.ConsoleCommands

import BasicClasses.SpaceMarine
import Utils.CollectionManager
import Utils.Creator

class Add : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute() {
        val spaceMarine = Creator().createSpaceMarine()
        CollectionManager().add(spaceMarine)
        println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
    }
}