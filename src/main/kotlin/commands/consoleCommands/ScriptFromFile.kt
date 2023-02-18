package commands.consoleCommands

class ScriptFromFile : Command() {
    override fun writeInfo() {
        println("Reads and executes script from provided file (The script should have the same commands used in the interactive mode)")
    }

    override fun execute(argument:String) {
        TODO("Not yet implemented")
    }
}