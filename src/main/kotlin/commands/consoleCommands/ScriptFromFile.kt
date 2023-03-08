package commands.consoleCommands

import commands.CommandInvoker
import commands.CommandReceiver
import commands.utils.Validator
import java.io.FileReader
import java.util.*

/**
 * Script from file
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
     * Runs script
     */
    override fun execute(args: List<String>) {
        if (Validator.verify(args)) {
            commandReceiver.executeScript(args[0])
        }
    }

}