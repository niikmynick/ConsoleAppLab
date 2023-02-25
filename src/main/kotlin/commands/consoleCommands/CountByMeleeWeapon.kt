package commands.consoleCommands

import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
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
class CountByMeleeWeapon(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Prints the amount of elements with the provided weapon"
    }

    /**
     * Prints the amount of Space Marines with the provided weapon
     * @param argument Contains [MeleeWeapon] that should be searched in collection
     */
    override fun execute(argument: String, sc: Scanner): String {
        val weapon : MeleeWeapon
        return if (collection.isNotEmpty()) {

            if (EnumReader.enumContains<MeleeWeapon>(argument.trim().uppercase())) {
                weapon = MeleeWeapon.valueOf(argument.trim().uppercase())
                val count = collection.countMeleeWeapons(weapon)

                "Elements with weapon $weapon found: $count\n"

            } else {
                "No MeleeWeapon named ${argument.trim()} was found\n"
            }
        } else {
            "The collection is empty\n"
        }
    }

}
