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
    override fun execute(argument:String, sc: Scanner): String {
        try {
            val file = FileReader(argument)
            val commandsList = file.readText()
            file.close()

            val scanner = Scanner(commandsList)
            var count = 0
            while (scanner.hasNextLine()) {
                val command: String = scanner.nextLine()
                commandInvoker.executeCommand(command, scanner)
                count += 1
            }
            scanner.close()
            return when (count) {
                0 -> "The file does not contain commands\n"
                1 -> "$count command has been executed\n"
                else -> "$count commands have been executed\n"
            }

        } catch (e: Exception) {
            return e.message.toString()
        }
    }
}