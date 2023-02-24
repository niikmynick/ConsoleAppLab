package utils.readers

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
        fun read(sc: Scanner): MeleeWeapon {
            println("Enter Weapon category from the list: ")
            for (weapon in MeleeWeapon.values()) {
                println(weapon)
            }
            var weapon = sc.nextLine().trim().uppercase()

            while (!enumContains<MeleeWeapon>(weapon)) {
                println("The entered weapon type doesn't exist. Try again: ")
                weapon = sc.nextLine().trim().uppercase()
            }
            return MeleeWeapon.valueOf(weapon)
        }

        /**
         * Sets a new [MeleeWeapon] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun update(element: SpaceMarine, sc:Scanner) {
            println("Enter Weapon category from the list (press enter to save existing parameter): ")
            for (weapon in MeleeWeapon.values()) {
                println(weapon)
            }
            var weapon = sc.nextLine().trim().uppercase()
            while (weapon.isNotEmpty() and !enumContains<MeleeWeapon>(weapon)) {
                println("The entered weapon type doesn't exist. Try again: ")
                weapon = sc.nextLine().trim().uppercase()
            }
            if (weapon.isNotEmpty()) {
                element.setMeleeWeapon(MeleeWeapon.valueOf(weapon))
            }

        }

    }
}