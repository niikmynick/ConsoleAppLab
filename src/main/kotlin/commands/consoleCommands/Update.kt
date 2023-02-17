package commands.consoleCommands

import utils.CollectionManager

class Update (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Обновляет значение элемента коллекции по заданному id")
    }

    override fun execute(argument:String) {
        println("Write the id of the object to change:")

        var id : Int = -1
        do {
            try {
                id = readln().trim().toInt()
            } catch (e: Exception) {
                println("Please enter a valid Int-type value of Id: ")
            }

        } while (id < 0)

        collection.update(id)
    }
}