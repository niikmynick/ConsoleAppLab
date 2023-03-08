package commands.consoleCommands

import commands.CommandReceiver
import java.util.Arrays
import java.util.Scanner

/**
 * Command
 *
 * @constructor Create empty Command
 */
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
     * @return
     */
    abstract fun execute(args: List<String>)
}