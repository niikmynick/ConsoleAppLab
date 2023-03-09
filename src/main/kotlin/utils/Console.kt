package utils

import collection.CollectionManager
import commands.CommandInvoker
import commands.CommandReceiver
import commands.consoleCommands.*
import java.io.IOException

/**
 * Class that handles commands and provides them all needed parameters
 * @property properties Contains system properties
 * @property fileManager Used for loading data to collection
 * @property commandInvoker See [CommandInvoker]
 * @property collectionManager Current collection
 * @property inputManager Gives input
 */
class Console {
    private val properties = System.getProperties()
    private val fileManager = FileManager(properties)
    private val commandInvoker = CommandInvoker()
    private val collectionManager = CollectionManager()
    private val inputManager = InputManager()
    private val commandReceiver = CommandReceiver(commandInvoker, collectionManager, inputManager)

    /**
     * Registers commands and waits for user prompt
     */
    fun initialize() {
        commandInvoker.register("info", Info(commandReceiver))
        commandInvoker.register("show", Show(commandReceiver))
        commandInvoker.register("add", Add(commandReceiver))
        commandInvoker.register("update_id", Update(commandReceiver))
        commandInvoker.register("remove_by_id", RemoveID(commandReceiver))
        commandInvoker.register("clear", Clear(commandReceiver))
        commandInvoker.register("save", Save(commandReceiver))
        commandInvoker.register("execute_script", ScriptFromFile(commandReceiver))
        commandInvoker.register("exit", Exit())
        commandInvoker.register("add_if_min", AddMin(commandReceiver))
        commandInvoker.register("remove_greater", RemoveGreater(commandReceiver))
        commandInvoker.register("remove_lower", RemoveLower(commandReceiver))
        commandInvoker.register("remove_any_by_chapter", RemoveAnyChapter(commandReceiver))
        commandInvoker.register("count_by_melee_weapon", CountByMeleeWeapon(commandReceiver))
        commandInvoker.register("filter_by_chapter", FilterByChapter(commandReceiver))

        commandInvoker.register("help", Help(commandReceiver))

        println(fileManager.load(collectionManager))
    }
    fun startInteractiveMode(){
        println("Waiting for user prompt ...")
            try {
                do {
                    print("$ ")
                    var input = inputManager.nextLine().trim().lowercase().split(" ")
                    commandInvoker.executeCommand(input)
                } while (input[0] != "exit")
            } catch (e:IOException) {
                println(e.message.toString())
            }
    }
}
