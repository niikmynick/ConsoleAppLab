package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Exit command
 *
 * @constructor Create command Exit
 */
class Exit() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Exits the app (without saving data)"
    }

    /**
     * Sets execution flag to false
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            setFlag(false)
        } else throw InvalidArgumentException("Too many arguments were entered")
    }
}