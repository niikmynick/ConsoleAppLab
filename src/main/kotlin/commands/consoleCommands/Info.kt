package commands.consoleCommands

import collection.CollectionManager
import commands.CommandReceiver
import commands.utils.Validator
import java.util.*

/**
 * Info
 *
 * Prints info about the collection (type, creation date, amount of elements)
 *
 * @property collection
 * @constructor Create command Info
 */
class Info() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Prints info about the collection (type, creation date, amount of elements)"
    }

    /**
     * Calls and prints [CollectionManager.info]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyArgs(args)) {
            commandReceiver.info()
        }
    }
}