package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Remove any chapter
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
     * Deletes first found Space Marine with a [basicClasses.Chapter] value equal to created
     * Prints whether a Space Marine was deleted or not
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.removeByChapter()
        }
    }
}
