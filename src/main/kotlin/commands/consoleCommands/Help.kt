package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Help command
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
     * Calls [CommandReceiver.help]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyOnlyArg(args)) {
            commandReceiver.help(args)
        } else throw InvalidArgumentException("Too many arguments were entered")
    }
}
