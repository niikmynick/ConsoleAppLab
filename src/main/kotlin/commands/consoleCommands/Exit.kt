package commands.consoleCommands

import kotlin.system.exitProcess

class Exit : Command() {
    override fun writeInfo() {
        println("Завершает программу (без сохранения в файл)")
    }

    override fun execute(argument:String) {
        println("Termination of work ...")
        exitProcess(0)
    }
}