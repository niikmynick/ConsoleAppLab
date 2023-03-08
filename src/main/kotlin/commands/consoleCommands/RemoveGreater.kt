package commands.consoleCommands

import exceptions.SpaceMarineNotFound
import collection.CollectionManager
import commands.CommandReceiver
import commands.utils.Validator
import java.util.*

/**
 * Remove greater
 *
 * Deletes from collection all elements greater than provided
 *
 * @property collection
 * @constructor Create command Remove greater
 */
class RemoveGreater() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Deletes from collection all elements greater than provided"
    }

    /**
     * Removes all elements greater than element with id
     * Prints the amount of Space Marines deleted
     */
    override fun execute(args: List<String>) {
        if (Validator.verify(args)) {
            commandReceiver.removeGreater(args[0])
        }
    }
}