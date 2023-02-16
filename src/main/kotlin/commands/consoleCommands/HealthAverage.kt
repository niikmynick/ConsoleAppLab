package commands.consoleCommands

import utils.CollectionManager

class HealthAverage (private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Выводит среднее значение поля health для всех элементов коллекции")
    }

    override fun execute(argument:String) {
        println("An average health value is ${collection.averageHealth()}")
    }
}