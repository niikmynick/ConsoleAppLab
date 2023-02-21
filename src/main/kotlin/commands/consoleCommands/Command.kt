package commands.consoleCommands

import kotlinx.serialization.Serializable

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
    abstract fun execute(argument:String)
}