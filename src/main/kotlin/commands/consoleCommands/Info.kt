package commands.consoleCommands

import utils.CollectionManager

class Info (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Выводит информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)")
    }

    override fun execute(argument:String) {
        println(collection.info())
    }

}