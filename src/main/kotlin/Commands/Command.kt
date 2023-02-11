package Commands

abstract class Command {
    abstract fun writeInfo()
    abstract fun execute()
}