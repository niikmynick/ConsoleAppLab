package commands.consoleCommands

import basicClasses.SpaceMarine
import utils.FileManager
import java.util.*

/**
 * Save
 *
 * Saves collection data into a file
 * 
 * @property collection
 * @property filename
 * @constructor Create command Save
 */
class Save(private val collection: TreeSet<SpaceMarine>, private val fileManager: FileManager) : Command() {
    override fun getInfo(): String {
        return "Сохраняет коллекцию в файл"
    }

    /**
     * Saves collection into file provided in [filename]
     */
    override fun execute(argument:String, sc: Scanner): String {
        val flag = fileManager.save(collection)
        return if (flag) {
            "Collection was saved successfully\n"
        } else {
            "Collection cannot be saved. An error occurred ...\n"
        }
    }
}