package commands.consoleCommands

import kotlinx.serialization.Serializable
import java.util.Scanner
/**
 * Abstract command description
 */
@Serializable
abstract class Command {
    /**
     * Write info
     *
     */
    abstract fun writeInfo()

    /**
     * Execute
     *
     * @param argument
     */
    abstract fun execute(argument:String, sc:Scanner)
}