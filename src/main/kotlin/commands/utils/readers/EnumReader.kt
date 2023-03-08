package commands.utils.readers

import basicClasses.AstartesCategory
import java.util.*

/**
 * Enum reader
 *
 * @constructor Create  Enum reader
 */
abstract class EnumReader {
    companion object {
        inline fun <reified T : Enum<T>> enumContains(name: String): Boolean {
            return enumValues<T>().any { it.name == name }
        }
    }
}