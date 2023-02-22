package commands.consoleCommands

import utils.CollectionManager
import java.util.*

/**
 * Command save: Saves collection data into a file
 * @param collection Current collection
 * @param filename Name of the file where data will be saved
 * @property info Has info about command
 */
class Save (private val collection: CollectionManager, private val filename: String) : Command() {
    override val info: String = "Saves collection data into a file"

    override fun execute(argument:String, sc: Scanner) {
        val flag = collection.save(filename)
        if (flag) {
            println("Collection was saved successfully")
        } else {
            println("Collection cannot be saved. An error occurred ...")
        }
    }
}