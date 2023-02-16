package commands.consoleCommands

import utils.CollectionManager

class RemoveID : Command() {
    override fun writeInfo() {
        println("Удаляет элемент из коллекции по его id")
    }

    override fun execute(argument:String) {
        val id = readln().trim().toInt()
        val name = CollectionManager().getByID(id).getName()
        CollectionManager().removeID(id)
        println("Space Marine $name has been deleted")
    }
}