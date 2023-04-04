package exceptions

/**
 * throws if entered value was ctrl+d
 */
class InvalidInputException : Exception() {
    override val message: String = "Invalid input"
}