package commands.consoleCommands

import utils.CollectionManager
import utils.readers.WeaponReader

class CountByMeleeWeapon(private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Prints the amount of elements with the provided weapon")
    }

    override fun execute(argument: String) {
        if (collection.isNotEmpty()) {
            val weapon = WeaponReader.read()
            val count = collection.countMeleeWeapons(weapon)
            println("Elements with weapon $weapon found: $count")
        }
        else {
            println("The collection is empty")
        }
    }

}
