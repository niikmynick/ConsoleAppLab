package commands.consoleCommands

/**
 * Command
 *
 * @constructor Create empty Command
 */
abstract class Command {
    private var executionFlag = true
    fun setFlag(flag:Boolean) {
        this.executionFlag = flag
    }

    fun getExecutionFlag(): Boolean {
        return executionFlag
    }

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