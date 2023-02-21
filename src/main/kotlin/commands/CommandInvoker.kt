package commands

import commands.consoleCommands.Command

/**
 * Command invoker
 *
 * @constructor Create Command invoker
 */
class CommandInvoker {
    private var list:Map<String, Command> = mapOf()

    /**
     * Register
     *
     * @param name
     * @param command
     */
    fun register(name: String, command: Command) {
        list += name to command
    }

    /**
     * Execute command
     *
     * @param query
     */
    fun executeCommand(query: String) {
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

    /**
     * Get commands list
     *
     * @return
     */
    fun getCommandsList() : Map<String, Command> {
        return this.list
    }
}