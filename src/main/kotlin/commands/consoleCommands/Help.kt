package commands.consoleCommands

class Help(private val list: Map<String, Command>) : Command() {
    override fun writeInfo() {
        println("Выводит справку по доступным командам")
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
