package commands.consoleCommands

import commands.CommandReceiver
import java.util.Scanner

/**
 * Help
 *
 * Prints info about all commands or a provided command
 *
 * @constructor Create command Help
 */
class Help() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Prints info about all commands or a provided command"
    }

    /**
     * Shows all commands when no argument was provided or shows info about provided command
     * @param args name of the command
     */
    override fun execute(args: List<String>) {
        commandReceiver.help(args)
    }
}
