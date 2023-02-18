package commands.consoleCommands

import utils.CollectionManager

class Show (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Prints all elements of the collection")
    }

    override fun execute(argument:String) {
        collection.show()
    }

}