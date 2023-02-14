package utils.readers

import basicClasses.MeleeWeapon

class MeleeWeaponReader : EnumReader() {
    companion object {
        fun read(): MeleeWeapon {
            println("Enter Astartes category from the list ${MeleeWeapon.values()}: ")
            var category = readln().trim()

            while (!enumContains<MeleeWeapon>(category)) {
                println("Seems like entered category doesn't exist. Try again: ")
                category = readln().trim()
            }
            return MeleeWeapon.valueOf(category)
        }

    }
}