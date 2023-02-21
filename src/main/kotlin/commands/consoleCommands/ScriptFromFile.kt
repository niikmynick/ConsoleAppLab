package commands.consoleCommands

import commands.CommandInvoker
import java.io.FileReader

/**
 * Script from file
 *
 * @property commandInvoker
 * @constructor Create command Script from file
 */
class ScriptFromFile(private val commandInvoker: CommandInvoker): Command() {
    override fun writeInfo() {
        println("Reads and executes script from provided file (The script should have the same commands used in the interactive mode)")
    }

    override fun execute(argument:String) {

        try {
            val file = FileReader(argument)
            for (command in file.readLines()) {
                if (command.isNotEmpty()) {
                    val query = command.split(" ")
                    commandInvoker.executeCommand(query[0])
                }
            }
            file.close()

            println("Script executed successfully")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}