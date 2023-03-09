package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Remove greater
 *
 * Deletes from collection all elements greater than provided
 *
 * @property collection
 * @constructor Create command Remove greater
 */
class RemoveGreater() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Deletes from collection all elements greater than provided"
    }

    /**
     * Removes all elements greater than element with id
     * Prints the amount of Space Marines deleted
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyArgs(args)) {
            commandReceiver.removeGreater(args[1])
        }
    }
}