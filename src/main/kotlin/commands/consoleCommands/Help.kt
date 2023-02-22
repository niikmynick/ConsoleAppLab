package commands.consoleCommands

import java.util.*

/**
 * Command help: Prints info about all commands or a provided command
 * @param list Map with all commands
 * @property info Has info about command
 */
class Help(private val list: Map<String, Command>) : Command() {
    override val info: String = "Prints info about all commands or a provided command"

    /**
     * Shows all commands when no argument was provided or shows info about provided command
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
                list[argument.lowercase()]?.writeInfo()
            }
        }
    }
}
