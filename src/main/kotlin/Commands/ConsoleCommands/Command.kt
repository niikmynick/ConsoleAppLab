package Commands.ConsoleCommands

abstract class Command {
    abstract fun writeInfo()
    abstract fun execute(vararg args:Any)
}