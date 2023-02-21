package commands

import commands.consoleCommands.Command

/**
 * Class that handles commands and call its execution
 * @property list Map containing command name as String and [Command] object
 */
class CommandInvoker {
    private var list:Map<String, Command> = mapOf()

    /**
     * Adds commands to [list]
     * @param name Name of the command in its console representation
     * @param command A [Command] object
     */
    fun register(name: String, command: Command) {
        list += name to command
    }

    /**
     * Executes command with provided arguments
     * @param query A single line string split into command and argument
     */
    fun executeCommand(query:String) {
        when (query.split(" ").size) {
            1 -> {
                list[query]?.execute("")
            }
            2 -> {
                val command = query.split(" ")[0]
                val argument = query.split(" ")[1]
                list[command]?.execute(argument)
            }
            else -> println("Too much arguments. Try again: ")
        }
    }

    fun getCommandsList() : Map<String, Command> {
        return list
    }
}