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
    override fun execute(argument:String, sc: Scanner) {
        when (argument.length) {
            0 -> {
                println("Help is available for the following commands:")
                for (key in list.keys) {
                    println("- ${key.uppercase()}")
                }
                println("For information on a command, type HELP {command name}")

            }
            else -> {
                println(list[argument.lowercase()]?.getInfo())
            }
        }
    }
}
