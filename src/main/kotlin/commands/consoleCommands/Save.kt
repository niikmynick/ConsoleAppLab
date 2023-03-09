package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Save
 *
 * Saves collection data into a file
 *
 * @constructor Create command Save
 */
class Save() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }

    override fun getInfo(): String {
        return "Saves the collection into file with provided name"
    }

    /**
     * Saves collection into file provided in file
     */
    override fun execute(args: List<String>) {
        if (Validator.verify(args, 2)) {
            if (args.size == 1) {
                println(commandReceiver.save(System.getProperty("COLLECTION_FILENAME")))
            } else {
                println(commandReceiver.save(args[1]))
            }
        }
    }
}