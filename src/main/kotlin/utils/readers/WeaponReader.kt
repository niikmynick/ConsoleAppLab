package utils.readers

import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine

class WeaponReader : EnumReader() {
    companion object {
        fun read(): MeleeWeapon {
            println("Enter Weapon category from the list: ")
            for (weapon in MeleeWeapon.values()) {
                println(weapon)
            }
            var weapon = readln().trim().uppercase()

            while (!enumContains<MeleeWeapon>(weapon)) {
                println("The entered weapon type doesn't exist. Try again: ")
                weapon = readln().trim().uppercase()
            }
            return MeleeWeapon.valueOf(weapon)
        }

        fun update(element: SpaceMarine) {
            println("Enter Weapon category from the list (press enter to save existing parameter): ")
            for (weapon in MeleeWeapon.values()) {
                println(weapon)
            }
            var weapon = readln().trim().uppercase()
            while (weapon.isNotEmpty() and !enumContains<MeleeWeapon>(weapon)) {
                println("The entered weapon type doesn't exist. Try again: ")
                weapon = readln().trim().uppercase()
            }
            if (weapon.isNotEmpty()) {
                element.setMeleeWeapon(MeleeWeapon.valueOf(weapon))
            }

        }

    }
}