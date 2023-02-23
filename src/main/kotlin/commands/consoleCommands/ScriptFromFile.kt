package commands.consoleCommands

import commands.CommandInvoker
import utils.CollectionManager
import java.io.FileReader
import java.util.*

/**
 * Command execute_script: Reads and executes script from provided file (The script should have the same commands used in the interactive mode)
 * @param collection Current collection
 * @param commandInvoker Invokes commands from file
 * @property info Has info about command
 */
class ScriptFromFile(val collection: CollectionManager, val commandInvoker: CommandInvoker) : Command() {
    override val info: String = "Reads and executes script from provided file (The script should have the same commands used in the interactive mode)"

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