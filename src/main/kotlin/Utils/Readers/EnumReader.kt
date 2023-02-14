package Utils.Readers

open abstract class EnumReader {
    companion object {
        inline fun <reified T : Enum<T>> enumContains(name: String): Boolean {
            return enumValues<T>().any { it.name == name }
        }
    }
}