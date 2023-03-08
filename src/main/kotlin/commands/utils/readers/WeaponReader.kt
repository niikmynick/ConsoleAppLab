package commands.utils.readers

import basicClasses.MeleeWeapon
import utils.InputManager

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
         * @return [MeleeWeapon] from entered value
         */
        fun read(inputManager: InputManager): MeleeWeapon {
            println("Enter Weapon category from the list: ")
            //val scanner = Scanner(System.`in`)

            for (weapon in MeleeWeapon.values()) {
                println(weapon)
            }
            var weapon = inputManager.nextLine().trim().uppercase()

            while (!enumContains<MeleeWeapon>(weapon)) {
                println("The entered weapon type doesn't exist. Try again: ")
                weapon = inputManager.nextLine().trim().uppercase()
            }
            return MeleeWeapon.valueOf(weapon)
        }
    }
}