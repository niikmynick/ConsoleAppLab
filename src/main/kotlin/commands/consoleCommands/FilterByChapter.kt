package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Filter by chapter
 *
 * Prints elements with the provided chapter
 *
 * @property collection
 * @constructor Create command Filter by chapter
 */
class FilterByChapter() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Prints elements with the provided chapter"
    }

    /**
     * Creates a [basicClasses.Chapter] and prints all elements with such Chapter
     */
    override fun execute(args: List<String>) {
        if (Validator.verify(args)) {
            commandReceiver.filterByChapter()
        }
    }
}
