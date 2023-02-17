package commands.consoleCommands

import utils.CollectionManager

class RemoveID (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Удаляет элемент из коллекции по его id")
    }

    override fun execute(argument:String) {
        println("Write the id of the object to remove:")

        var id : Int = -1
        do {
            try {
                id = readln().trim().toInt()
            } catch (e: Exception) {
                println("Please enter a valid Int-type value of Id: ")
            }

        } while (id < 0)
        if (collection.getByID(id) != null) {
            val name = collection.getByID(id)!!.getName()
            collection.removeID(id)
            println("Space Marine $name has been deleted")
        } else println("No element with Id=$id was found")



    }
}