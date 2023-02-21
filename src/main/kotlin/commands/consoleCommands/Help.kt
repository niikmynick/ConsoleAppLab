package commands.consoleCommands

/**
 * Help
 *
 * @property list
 * @constructor Create command Help
 */
class Help(private val list: Map<String, Command>) : Command() {
    override fun writeInfo() {
        println("Prints info about all commands or a provided command")
    }

    override fun execute(argument:String) {
        when (argument.length) {
            0 -> {
                println("Help is available for the following commands:")
                for (key in list.keys) {
                    println("- ${key.uppercase()}")
                }
                println("For information on a command, type HELP <command name>")

            }
            else -> {
                list[argument.lowercase()]?.writeInfo()
            }
        }
    }
}
