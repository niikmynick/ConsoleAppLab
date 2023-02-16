package commands.consoleCommands

abstract class Command {
    abstract fun writeInfo()
    abstract fun execute(argument:String)
}