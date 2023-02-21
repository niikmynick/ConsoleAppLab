package utils

import commands.CommandInvoker
import commands.consoleCommands.*

/**
 * Console
 *
 * @constructor Create Console
 */
class Console {
    /**
     * Start interactive mode
     *
     */
    fun startInteractiveMode() {
        val commandInvoker = CommandInvoker()
        val fileManager = FileManager()
        val collection = CollectionManager()

        var command:String

        commandInvoker.register("info", Info(collection))
        commandInvoker.register("show", Show(collection))
        commandInvoker.register("add", Add(collection))
        commandInvoker.register("update_id", Update(collection))
        commandInvoker.register("remove_by_id", RemoveID(collection))
        commandInvoker.register("clear", Clear(collection))
        commandInvoker.register("save", Save(collection, fileManager.getFilename()))
        commandInvoker.register("execute_script", ScriptFromFile(commandInvoker))
        commandInvoker.register("exit", Exit())
        commandInvoker.register("add_if_min", AddMin(collection))
        commandInvoker.register("remove_greater", RemoveGreater(collection))
        commandInvoker.register("remove_lower", RemoveLower(collection))
        commandInvoker.register("remove_any_by_chapter", RemoveAnyChapter(collection))
        commandInvoker.register("count_by_melee_weapon", CountByMeleeWeapon(collection))
        commandInvoker.register("filter_by_chapter", FilterByChapter(collection))

        commandInvoker.register("help", Help(commandInvoker.getCommandsList()))

        fileManager.load(collection)

        println("Waiting for the user command ...")
        do {
            print("$ ")
            command = readln().trim()
            commandInvoker.executeCommand(command)
        } while (command != "exit")
    }
}