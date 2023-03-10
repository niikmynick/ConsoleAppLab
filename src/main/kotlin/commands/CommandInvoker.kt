package commands

import commands.consoleCommands.Command
import utils.OutputManager

/**
 * Command invoker
 * 
 * Class that handles commands and call its execution
 *
 * @constructor Create Command invoker
 */
class CommandInvoker(private val outputManager: OutputManager) {
    private var commandMap:Map<String, Command> = mapOf()
    private var commandsHistory:Array<String> = arrayOf()

    /**
     * Register
     *
     * Add commands to [commandMap]
     *
     * @param name Name of the command in its console representation
     * @param command A [Command] object
     */
    fun register(name: String, command: Command) {
        commandMap += name to command
    }

    /**
     * Execute command
     *
     * Executes command with provided arguments
     *
     * @param query A single line string split into command and argument
     */
    fun executeCommand(query: List<String>) {
        try {
            if (query.isNotEmpty()) {
                commandsHistory += query[0]
                val command: Command = commandMap[query[0]]!!
                command.execute(query)
            }
        } catch (e:IllegalStateException) {
            outputManager.println("Command ${query[0]} does not exist")
        } catch (e:NullPointerException) {
            outputManager.println("Command ${query[0]} does not exist")
        }
    }

    /**
     * Get commands list
     *
     * @return
     */
    fun getCommandMap() : Map<String, Command> {
        return commandMap
    }
}