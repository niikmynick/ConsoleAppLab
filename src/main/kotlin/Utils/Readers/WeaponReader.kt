package Utils.Readers

import BasicClasses.MeleeWeapon

class WeaponReader : Reader() {
    companion object {
        fun read(): MeleeWeapon {
            print("Enter Astartes category from the list ${MeleeWeapon.values()}: ")
            var category = readln().trim()
            if (category.equals("") or !enumContains<MeleeWeapon>(category)) {
                while (!enumContains<MeleeWeapon>(category)) {
                    print("Seems like entered category doesn't exist. Try again: ")
                    category = readln().trim()
                }
            }
            return MeleeWeapon.valueOf(category)
        }

    }
}