package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Remove any chapter command
 *
 * Deletes an element with a provided chapter value
 *
 * @property collection
 * @constructor Create command Remove any chapter
 */
class RemoveAnyChapter() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Deletes an element with a provided chapter value"
    }

    /**
     * Calls [CommandReceiver.removeByChapter]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.removeByChapter()
        } else throw InvalidArgumentException("Too many arguments were entered")
    }
}
