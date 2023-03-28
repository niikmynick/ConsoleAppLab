package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Script from file command
 *
 * Reads and executes script from provided file (The script should have the same commands used in the interactive mode
 *
 * @constructor Create command Script from file
 */
class ScriptFromFile(): Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Reads and executes script from provided file (The script should have the same commands used in the interactive mode)"
    }

    /**
     * Calls [CommandReceiver.executeScript]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyOnlyArg(args)) {
            try {
                commandReceiver.executeScript(args[1])
            } catch (e:IndexOutOfBoundsException) {
                throw InvalidArgumentException("Expected an argument but it was not found")
            }
        } else throw InvalidArgumentException("Too many arguments were entered")
    }

}