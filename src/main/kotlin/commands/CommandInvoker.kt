package commands

import commands.consoleCommands.Command
import exceptions.CommandNotFound
import java.util.Scanner

/**
 * Command invoker
 * 
 * Class that handles commands and call its execution
 *
 * @constructor Create Command invoker
 */
class CommandInvoker {
    private var list:Map<String, Command> = mapOf()

    /**
     * Register
     *
     * Add commands to [list]
     *
     * @param name Name of the command in its console representation
     * @param command A [Command] object
     */
    fun register(name: String, command: Command) {
        list += name to command
    }

    /**
     * Execute command
     *
     * Executes command with provided arguments
     *
     * @param query A single line string split into command and argument
     */
    fun executeCommand(query:String, sc:Scanner) {
        when (query.split(" ").size) {
            1 -> {
                if (query in list) {
                    print("${list[query]?.execute("", sc)}\n")
                } else
                    throw CommandNotFound("Command $query does not exist\n")

            }
            2 -> {
                if (query.split(" ")[0] in list) {
                    val command = query.split(" ")[0]
                    val argument = query.split(" ")[1]
                    print("${list[command]?.execute(argument, sc)}\n")
                } else
                    throw CommandNotFound("Command ${query.split(" ")[0]} does not exist\n")
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
        return list
    }
}