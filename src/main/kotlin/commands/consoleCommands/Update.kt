package commands.consoleCommands

import collection.CollectionManager
import commands.CommandReceiver
import commands.utils.Validator

/**
 * Update
 *
 * Update values of the element with the provided id
 *
 * @constructor Create command Update
 */
class Update() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Updates values of the element with the provided id"
    }

    /**
     * Calls [CollectionManager.update] with provided id
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.updateByID(args[1])
        }
    }

}