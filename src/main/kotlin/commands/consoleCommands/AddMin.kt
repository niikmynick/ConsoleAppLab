package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Add min command
 *
 * Adds a new element into the collection if its value is lower than the lowest element in the collection
 *
 * @property collection
 * @constructor Create command Add min
 */
class AddMin() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Adds a new element into the collection if its value is lower than the lowest element in the collection"
    }

    /**
     * Calls [CommandReceiver.addMin]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.addMin()
        } else throw InvalidArgumentException("Too many arguments were entered")
    }
}