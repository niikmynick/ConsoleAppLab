package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException


/**
 * Add command
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
     * Calls [CommandReceiver.add]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.add()
        } else if (Validator.verifyList(args)) {
            commandReceiver.add(args)
        } else throw InvalidArgumentException("Invalid arguments were entered. Use HELP command to check")
    }
}
