package commands.consoleCommands

import java.util.Scanner
import kotlin.system.exitProcess

/**
 * Exit
 *
 * @constructor Create command Exit
 */
class Exit : Command() {
    override fun getInfo(): String {
        return "Exits the app (without saving data)"
    }
    /**
     * Closes program using [exitProcess] with status 0
     */
    override fun execute(argument:String, sc: Scanner): String {
        return "Finishing process ...\n"
    }
}