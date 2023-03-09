package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Remove i d
 *
 * Deletes the element with the provided id
 *
 * @property collection
 * @constructor Create command remove_id
 */
class RemoveID() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Deletes the element with the provided id"
    }

    /**
     * Deletes element with id equal to provided in argument
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyArgs(args)) {
            commandReceiver.removeByID(args[1])
        }
    }


}