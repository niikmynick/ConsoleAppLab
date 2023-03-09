package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import java.util.Scanner
import kotlin.system.exitProcess

/**
 * Exit
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
     * Closes program using [exitProcess] with status 0
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            setFlag(false)
        }
    }
}