package commands.consoleCommands

import utils.CollectionManager
import java.util.Scanner

/**
 * Save
 *
 * Saves collection data into a file
 * 
 * @property collection
 * @property filename
 * @constructor Create command Save
 */
class Save (private val collection: CollectionManager, private val filename: String) : Command() {
    override fun getInfo(): String {
        return "Сохраняет коллекцию в файл"
    }

    /**
     * Saves collection into file provided in [filename]
     */
    override fun execute(argument:String, sc: Scanner): String {
        val flag = collection.save(filename)
        return if (flag) {
            "Collection was saved successfully\n"
        } else {
            "Collection cannot be saved. An error occurred ...\n"
        }
    }
}