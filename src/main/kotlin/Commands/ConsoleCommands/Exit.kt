package Commands.ConsoleCommands

import kotlin.system.exitProcess

class Exit {
    fun execute() {
        println("Termination of work ...")
        println("Bye")

        exitProcess(0)
    }
}