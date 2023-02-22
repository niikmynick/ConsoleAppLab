package utils.readers

import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
import java.util.*

class WeaponReader : EnumReader() {
    companion object {
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