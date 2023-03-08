package commands.utils.readers

import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
import java.util.Scanner

/**
 * Weapon reader
 *
 * Class containing readers for [MeleeWeapon]
 *
 * @constructor Create Weapon reader
 */
class WeaponReader : EnumReader() {
    companion object {
        /**
         * Prints all values from [MeleeWeapon] and reads entered value
         * @param sc Is where a new line is gotten
         * @return [MeleeWeapon] from entered value
         */
        fun read(): MeleeWeapon {
            println("Enter Weapon category from the list: ")
            val scanner = Scanner(System.`in`)

            for (weapon in MeleeWeapon.values()) {
                println(weapon)
            }
            var weapon = scanner.nextLine().trim().uppercase()

            while (!enumContains<MeleeWeapon>(weapon)) {
                println("The entered weapon type doesn't exist. Try again: ")
                weapon = scanner.nextLine().trim().uppercase()
            }
            return MeleeWeapon.valueOf(weapon)
        }
    }
}