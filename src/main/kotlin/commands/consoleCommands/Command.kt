package commands.consoleCommands

abstract class Command {
    abstract fun writeInfo()
    abstract fun execute(vararg args:Any)
}