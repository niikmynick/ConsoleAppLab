package commands

import commands.consoleCommands.Command

class CommandInvoker {
    private var list:Map<String, Command> = mapOf()
    fun register(name: String, command: Command) {
        list += name to command
    }

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

    fun getCommandsList() : Map<String, Command> {
        return this.list
    }
}