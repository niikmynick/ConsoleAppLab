package commands.consoleCommands

import utils.CollectionManager

class UniqueWeapons : Command(){
    override fun writeInfo() {
        println("Выводит уникальные значения поля meleeWeapon всех элементов в коллекции")
    }

    override fun execute(argument:String) {
        println("Here is a list of weapons from our collection: ")
        for (weapon in CollectionManager().uniqueWeapons()) {
            println(weapon)
        }
    }
}