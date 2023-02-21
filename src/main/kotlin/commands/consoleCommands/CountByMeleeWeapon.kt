package commands.consoleCommands

import basicClasses.MeleeWeapon
import utils.CollectionManager
import utils.readers.EnumReader

/**
 * Command count_by_melee_weapon: Prints the amount of elements with the provided weapon
 * @param collection Current collection
 * @property info Has info about command
 */
class CountByMeleeWeapon(private val collection: CollectionManager) : Command() {
    override val info: String = "Prints the amount of elements with the provided weapon as argument\n (count_by_melee_weapon {MeleeWeapon})"

    /**
     * @param argument Contains [MeleeWeapon] that should be searched in collection
     */
    override fun execute(argument: String) {
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
