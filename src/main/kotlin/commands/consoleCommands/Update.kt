package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Update command
 *
 * Update values of the element with the provided id
 *
 * @constructor Create command Update
 */
class Update() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Updates values of the element with the provided id"
    }

    /**
     * Calls [CommandReceiver.updateByID] with provided id
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyOnlyArg(args)) {
            try {
                commandReceiver.updateByID(args[1])
            } catch (e:Exception) {
                throw InvalidArgumentException("Expected an argument but it was not found")
            }
        } else throw InvalidArgumentException("Too many arguments were entered")
    }

}