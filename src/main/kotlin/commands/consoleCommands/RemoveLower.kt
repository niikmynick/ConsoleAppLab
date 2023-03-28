package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Remove lower command
 *
 * Deletes from collection all elements lower than provided
 *
 * @property collection
 * @constructor Create command Remove lower
 */
class RemoveLower() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Deletes from collection all elements lower than provided"
    }

    /**
     * Calls [CommandReceiver.removeLower]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyOnlyArg(args)) {
            try {
                commandReceiver.removeLower(args[1])
            } catch (e:Exception) {
                throw InvalidArgumentException("Expected an argument but it was not found")
            }
        } else throw InvalidArgumentException("Too many arguments were entered")
    }
}