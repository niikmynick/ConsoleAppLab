package commands.consoleCommands

import utils.CollectionManager

class Show (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Выводит все элементы коллекции в строковом представлении")
    }

    override fun execute(argument:String) {
        collection.show()
    }

}