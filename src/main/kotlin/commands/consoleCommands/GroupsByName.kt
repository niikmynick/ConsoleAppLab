package commands.consoleCommands

import utils.CollectionManager

class GroupsByName : Command() {
    override fun writeInfo() {
        println("Группирует элементы коллекции по значению поля name, выводит количество элементов в каждой группе")
    }

    override fun execute(argument:String) {
        CollectionManager().groupByName()
    }
}