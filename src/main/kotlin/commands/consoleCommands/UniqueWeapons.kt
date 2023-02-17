package commands.consoleCommands

import utils.CollectionManager

class UniqueWeapons (private val collection: CollectionManager) : Command(){
    override fun writeInfo() {
        println("Выводит уникальные значения поля meleeWeapon всех элементов в коллекции")
    }

    override fun execute(argument:String) {
        println("Here is a list of weapons from our collection: ")
        for (weapon in collection.uniqueWeapons()) {
            println(weapon)
        }
    }
}