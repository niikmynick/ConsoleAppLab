package commands.consoleCommands

import utils.CollectionManager

class RemoveID (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Удаляет элемент из коллекции по его id")
    }

    override fun execute(argument:String) {
        val id = readln().trim().toInt()
        val name = collection.getByID(id).getName()
        collection.removeID(id)
        println("Space Marine $name has been deleted")
    }
}