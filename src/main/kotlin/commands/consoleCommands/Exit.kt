package commands.consoleCommands

import java.util.*
import kotlin.system.exitProcess

/**
 * Command exit: Adds a new element into the collection
 * @property info Has info about command
 */
class Exit : Command() {
    override val info: String = "Exits the app (without saving data)"

    /**
     * Closes program using [exitProcess] with status 0
     */
    override fun execute(argument:String, sc: Scanner) {
        println("Exiting ...")
        exitProcess(0)
    }
}