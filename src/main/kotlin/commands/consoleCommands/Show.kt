package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Show command
 *
 * Prints all elements of the collection
 *
 * @constructor Create command Show
 */
class Show() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Prints all elements of the collection"
    }

    /**
     * Calls [CommandReceiver.show]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.show()
        } else throw InvalidArgumentException("Too many arguments were entered")
    }

}