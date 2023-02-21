package commands.consoleCommands

import utils.CollectionManager

class Update (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Updates values of the element with the provided id")
    }

    override fun execute(argument:String) {
        print("Write the id of the object to change:    ")

        var id = -1L
        do {
            try {
                id = readln().trim().toLong()
            } catch (e: Exception) {
                print("Please enter a valid value of id:  ")
            }

        } while (id < 0)

        collection.update(id)
    }
}