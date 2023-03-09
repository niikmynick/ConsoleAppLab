package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Remove lower
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
     * Removes all elements lower than element with id equal to argument
     * Prints the amount of Space Marines deleted
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.removeLower(args[1])
        }
    }
}