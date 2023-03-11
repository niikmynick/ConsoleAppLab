package exceptions

class RecursiveCallException : Exception() {
    override val message: String = "Script can cause a recursive call so command was skipped"
}