package commands.consoleCommands

import utils.CollectionManager

/**
 * Save
 *
 * @property collection
 * @property filename
 * @constructor Create command Save
 */
class Save (private val collection: CollectionManager, private val filename: String) : Command() {
    override fun writeInfo() {
        println("Сохраняет коллекцию в файл")
    }

    override fun execute(argument:String) {
        val flag = collection.save(filename)
        if (flag) {
            println("Collection was saved successfully")
        } else {
            println("Collection can not be saved. An error occurred ...")
        }
    }
}