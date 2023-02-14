package Commands.ConsoleCommands

import kotlin.system.exitProcess

class Exit : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute() {
        println("Termination of work ...")
        println("Bye")

        exitProcess(0)
    }
}