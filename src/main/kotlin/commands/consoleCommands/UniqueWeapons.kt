package commands.consoleCommands

import utils.CollectionManager

class UniqueWeapons (private val collection: CollectionManager) : Command(){
    override fun writeInfo() {
        println("Prints unique values of meleeWeapon from elements in the collection")
    }

    override fun execute(argument:String) {
        println("Here is a list of weapons from our collection: ")
        for (weapon in collection.uniqueWeapons()) {
            println(weapon)
        }
    }
}