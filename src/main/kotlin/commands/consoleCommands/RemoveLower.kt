package commands.consoleCommands

import utils.CollectionManager
import utils.Creator

class RemoveLower (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Deletes from collection all elements lower than provided")
    }

    override fun execute(argument:String) {
        print("Write the id of the object to compare:   ")

        var id = -1L
        do {
            try {
                id = readln().trim().toLong()
            } catch (e: Exception) {
                print("Please enter a valid Long-type value of id:  ")
            }

        } while (id < 0)
        if (collection.getByID(id) == null) println("No element with Id=$id was found")
        else {
            val amount : Int = collection.removeLower(collection.getByID(id)!!)
            println("Have been deleted $amount Space Marines")
        }

    }
}