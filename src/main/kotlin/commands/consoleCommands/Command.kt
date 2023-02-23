package commands.consoleCommands

import java.util.Scanner

/**
 * Abstract class for commands
 * @property info Saves info about command
 */
abstract class Command {
    abstract val info: String

    /**
     * Prints info of command
     *
     * Can be overwritten for each command
     */
    open fun writeInfo() {
        println(info)
    }
    abstract fun execute(argument:String, sc:Scanner)
}