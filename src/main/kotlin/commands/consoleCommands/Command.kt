package commands.consoleCommands

import kotlinx.serialization.Serializable

@Serializable
abstract class Command {
    abstract fun writeInfo()
    abstract fun execute(argument:String)
}