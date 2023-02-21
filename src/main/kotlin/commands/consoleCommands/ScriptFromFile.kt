package commands.consoleCommands

import commands.CommandInvoker
import utils.CollectionManager
import java.io.FileReader
import java.util.*

class ScriptFromFile(val collection: CollectionManager, val commandInvoker: CommandInvoker) : Command() {

    override fun writeInfo() {
        println("Reads and executes script from provided file (The script should have the same commands used in the interactive mode)")
    }

    override fun execute(argument:String) {
        try {
            val filereader = FileReader(argument)
            val commandlist = filereader.readText()
            filereader.close()

            val scanner = Scanner(commandlist)
            while (scanner.hasNextLine()) {
                val command: String = scanner.nextLine()
                commandInvoker.executeCommand(command)
            }
            scanner.close()
            } catch (e: Exception) {
            println(e.message)
        }

    }
}