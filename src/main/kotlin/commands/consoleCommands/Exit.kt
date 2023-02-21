package commands.consoleCommands

import kotlin.system.exitProcess

class Exit : Command() {
    override fun writeInfo() {
        println("Exits the app (without saving data)")
    }

    override fun execute(argument:String) {
        println("Finishing process ...")
        exitProcess(0)
    }
}