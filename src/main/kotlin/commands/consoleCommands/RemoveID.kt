package commands.consoleCommands

import utils.CollectionManager

class RemoveID (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Deletes the element with the provided id")
    }

    override fun execute(argument:String) {
        print("Write the id of the object to remove:")

        var id = -1L
        do {
            try {
                id = readln().trim().toLong()
            } catch (e: Exception) {
                print("Please enter a valid Long-type value of Id: ")
            }

        } while (id < 0)
        if (collection.getByID(id) != null) {
            val name = collection.getByID(id)!!.getName()
            collection.removeID(id)
            println("Space Marine $name has been deleted")
        } else println("No element with Id=$id was found")



    }
}