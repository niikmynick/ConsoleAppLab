package commands.consoleCommands

import commands.CommandReceiver
import exceptions.InvalidArgumentException

/**
 * Save command
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
     * Calls [CommandReceiver.save]
     */
    override fun execute(args: List<String>) {
        when (args.size) {
            1 -> {
                commandReceiver.save("")
            }
            2 -> {
                commandReceiver.save(args[1])
            }
            else -> throw InvalidArgumentException("Too many arguments were entered")
        }
    }
}