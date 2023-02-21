package commands.consoleCommands

import basicClasses.MeleeWeapon
import utils.CollectionManager
import utils.readers.EnumReader
import utils.readers.WeaponReader

class CountByMeleeWeapon(private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Prints the amount of elements with the provided weapon")
    }

    override fun execute(argument: String) {
        val weapon : MeleeWeapon
        if (collection.isNotEmpty()) {
            if (EnumReader.enumContains<MeleeWeapon>(argument.trim().uppercase())) {
                weapon = MeleeWeapon.valueOf(argument.trim().uppercase())
            } else {
                weapon = WeaponReader.read()
            }
            val count = collection.countMeleeWeapons(weapon)
            println("Elements with weapon $weapon found: $count")
        }
        else {
            println("The collection is empty")
        }
    }

}
