package Commands.ConsoleCommands

import BasicClasses.SpaceMarine
import Utils.CollectionManager
import Utils.Creator

class Add : Command() {
    val spaceMarine = Creator().createSpaceMarine()
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(element: Any) {
        if (element is SpaceMarine) {
            CollectionManager().add(element)
        } else {
            TODO() // trow exception
        }
    }
}