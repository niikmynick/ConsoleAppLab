package commands.consoleCommands

import kotlinx.serialization.Serializable
import java.util.Scanner

/**
 * Command
 *
 * @constructor Create empty Command
 */
@Serializable
abstract class Command {

    /**
     * Get info
     *
     * @return
     */
    abstract fun getInfo(): String

    /**
     * Execute
     *
     * @param argument
     * @param sc
     */
    abstract fun execute(argument:String, sc:Scanner): String
}