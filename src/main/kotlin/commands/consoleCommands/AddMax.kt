package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class AddMax : Command() {
    override fun writeInfo() {
        println("Добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции")
    }

    override fun execute(argument:String) {
        val spaceMarine = Creator().createSpaceMarine()
        val flag:Boolean = CollectionManager().addMax(spaceMarine)
        if (flag) {
            println("Space Marine ${spaceMarine.getName()} has been added to list")
        } else {
            println("Space Marine ${spaceMarine.getName()} has not been added to list")
        }
    }
}