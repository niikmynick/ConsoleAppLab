package commands.consoleCommands

import utils.CollectionManager

class Save (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Сохраняет коллекцию в файл")
    }

    override fun execute(argument:String) {
        val flag = collection.save()
        if (flag) {
            println("Collection was saved successfully")
        } else {
            println("Collection can not be saved. An error occurred ...")
        }
    }
}