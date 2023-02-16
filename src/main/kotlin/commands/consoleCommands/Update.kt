package commands.consoleCommands

import utils.CollectionManager

class Update (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Обновляет значение элемента коллекции по заданному id")
    }

    override fun execute(argument:String) {
        val id = readln().trim().toInt()
        CollectionManager().update(id)
    }
}