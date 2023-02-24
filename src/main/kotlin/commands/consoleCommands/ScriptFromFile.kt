package commands.consoleCommands

import commands.CommandInvoker
import java.io.FileReader
import java.util.*

/**
 * Script from file
 *
 * Reads and executes script from provided file (The script should have the same commands used in the interactive mode
 *
 * @property commandInvoker
 * @constructor Create command Script from file
 */
class ScriptFromFile(private val commandInvoker: CommandInvoker): Command() {
    override fun getInfo(): String {
        return "Reads and executes script from provided file (The script should have the same commands used in the interactive mode)"
    }

    /**
     * Runs script and redirects contents in script to [commandInvoker]
     */
    override fun execute(argument:String, sc: Scanner) {
        try {
            val file = FileReader(argument)
            val commandsList = file.readText()
            file.close()

            val scanner = Scanner(commandsList)
            while (scanner.hasNextLine()) {
                val command: String = scanner.nextLine()
                commandInvoker.executeCommand(command, scanner)
            }
            scanner.close()
        } catch (e: Exception) {
            println(e.message)
        }

    }
}