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
        return "Сохраняет коллекцию в файл"
    }

    /**
     * Saves collection into file provided in file
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyArgs(args)) {
            commandReceiver.save(args[1])
        }
    }
}