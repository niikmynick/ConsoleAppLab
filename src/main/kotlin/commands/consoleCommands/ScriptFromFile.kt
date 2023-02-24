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
    override fun writeInfo() {
        println("Reads and executes script from provided file (The script should have the same commands used in the interactive mode)")
    }

    /**
     * Runs script and redirects contents in script to [commandInvoker]
     */
    override fun execute(argument:String, sc: Scanner) {
        try {
            val filereader = FileReader(argument)
            val commandlist = filereader.readText()
            filereader.close()

            val scanner = Scanner(commandlist)
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