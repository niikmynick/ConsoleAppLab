package commands.consoleCommands

import utils.CollectionManager

class Save (private val collection: CollectionManager, private val filename: String) : Command() {
    override fun writeInfo() {
        println("Saves collection data into a file")
    }

    override fun execute(argument:String) {
        val flag = collection.save(filename)
        if (flag) {
            println("Collection was saved successfully")
        } else {
            println("Collection cannot be saved. An error occurred ...")
        }
    }
}