package commands.consoleCommands

import utils.CollectionManager

/**
 * Command print_unique_weapons: no longer needed
 * "Prints unique values of meleeWeapon from elements in the collection"
 */
class UniqueWeapons (private val collection: CollectionManager) : Command(){
    override val info: String = "Prints unique values of meleeWeapon from elements in the collection"

    override fun execute(argument:String) {
        println("Here is a list of weapons from our collection: ")
        for (weapon in collection.uniqueWeapons()) {
            println(weapon)
        }
    }
}