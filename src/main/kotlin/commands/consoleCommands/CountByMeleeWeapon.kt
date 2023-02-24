package commands.consoleCommands

import basicClasses.MeleeWeapon
import utils.CollectionManager
import utils.readers.EnumReader
import java.util.*

/**
 * Count by melee weapon
 *
 * Prints the amount of elements with the provided weapon
 *
 * @property collection
 * @constructor Create command count_by_melee_weapon
 */
class CountByMeleeWeapon(private val collection: CollectionManager) : Command() {
    override fun getInfo(): String {
        return "Prints the amount of elements with the provided weapon"
    }

    /**
     * Prints the amount of Space Marines with the provided weapon
     * @param argument Contains [MeleeWeapon] that should be searched in collection
     */
    override fun execute(argument: String, sc: Scanner) {
        val weapon : MeleeWeapon
        if (collection.isNotEmpty()) {
            if (EnumReader.enumContains<MeleeWeapon>(argument.trim().uppercase())) {
                weapon = MeleeWeapon.valueOf(argument.trim().uppercase())
                val count = collection.countMeleeWeapons(weapon)
                println("Elements with weapon $weapon found: $count")
            } else {
                println("No MeleeWeapon named ${argument.trim()} was found")
            }
        }
        else {
            println("The collection is empty")
        }
    }

}
