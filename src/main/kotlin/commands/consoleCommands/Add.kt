package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator


/**
 * Add
 *
 * @constructor Create empty Add
 */
class Add() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Adds a new element into the collection"
    }

    /**
     * Creates a Space Marine and adds it into the collection
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyArgs(args)) {
            commandReceiver.add()
        }
    }
}
