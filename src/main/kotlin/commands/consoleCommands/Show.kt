package commands.consoleCommands

import utils.CollectionManager

class Show : Command() {
    override fun writeInfo() {
        println("Выводит все элементы коллекции в строковом представлении")
    }

    override fun execute(argument:String) {
        CollectionManager().show()
    }

}