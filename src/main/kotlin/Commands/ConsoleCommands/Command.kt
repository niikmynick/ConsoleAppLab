package Commands.ConsoleCommands

abstract class Command {
    abstract fun writeInfo()
    abstract fun execute(element: Any)
}