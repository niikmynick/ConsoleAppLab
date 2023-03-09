package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import java.util.*

/**
 * Add min
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
     * Creates a Space Marine and add it into the collection if it lower than the lowest element in the collection
     * Prints whether the Space Marine was added or not
     * @param sc Is given to creator
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyArgs(args)) {
            commandReceiver.addMin()
        }
    }
}