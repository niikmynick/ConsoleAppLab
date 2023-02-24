package commands.consoleCommands

import java.util.Scanner

/**
 * Help
 *
 * Prints info about all commands or a provided command
 *
 * @property list
 * @constructor Create command Help
 */
class Help(private val list: Map<String, Command>) : Command() {
    override fun getInfo(): String {
        return "Prints info about all commands or a provided command"
    }

    /**
     * Shows all commands when no argument was provided or shows info about provided command
     * @param argument Name of the command
     */
    override fun execute(argument:String, sc: Scanner): String {
        var output = ""
        when (argument.length) {
            0 -> {
                output += "Help is available for the following commands:\n"
                for (key in list.keys) {
                    output += "- ${key.uppercase()}\n"
                }
                output += "For information on a command, type HELP {command name}"
            }
            else -> {
                output += list[argument.lowercase()]?.getInfo().toString()
            }
        }
        return output
    }
}
