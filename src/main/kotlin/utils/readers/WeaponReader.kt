package utils.readers

import basicClasses.MeleeWeapon

class WeaponReader : EnumReader() {
    companion object {
        fun read(): MeleeWeapon {
            println("Enter Weapon category from the list: ")
            for (weapon in MeleeWeapon.values()) {
                println(weapon)
            }
            var weapon = readln().trim().uppercase()

            while (!enumContains<MeleeWeapon>(weapon)) {
                println("Seems like entered weapon type doesn't exist. Try again: ")
                weapon = readln().trim().uppercase()
            }
            return MeleeWeapon.valueOf(weapon)
        }

    }
}