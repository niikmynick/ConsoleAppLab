package Utils.Readers

import BasicClasses.MeleeWeapon

open abstract class Reader {
    companion object {
        inline fun <reified T : Enum<T>> enumContains(name: String): Boolean {
            return enumValues<T>().any { it.name == name }
        }
    }
}