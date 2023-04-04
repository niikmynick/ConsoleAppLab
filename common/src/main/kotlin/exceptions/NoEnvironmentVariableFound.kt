package exceptions

class NoEnvironmentVariableFound : Exception() {
    override val message: String = "No value of environment variable 'COLLECTION' was found"
}