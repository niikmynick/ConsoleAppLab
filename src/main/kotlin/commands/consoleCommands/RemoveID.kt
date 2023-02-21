package commands.consoleCommands

import exceptions.SpaceMarineNotFound
import utils.CollectionManager

class RemoveID (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Deletes the element with the provided id")
    }

    override fun execute(argument:String) {
        var id = 0L
            try {
                id = argument.trim().toLong()
                if (collection.getByID(id) != null) {
                    val name = collection.getByID(id)!!.getName()
                    collection.removeID(id)
                    println("Space Marine $name has been deleted")
                } else throw SpaceMarineNotFound("No element with Id=$id was found")
            } catch (e: Exception) {
                println("No element with Id=$id was found")
            }
    }
}