package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Clear
 *
 * Clears all elements in the collection
 * 
 * @property collection
 * @constructor Create command Clear
 */
class Clear() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Clears all elements in the collection"
    }

    /**
     * Clears all elements in the collection
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.clear()
        }
    }
}