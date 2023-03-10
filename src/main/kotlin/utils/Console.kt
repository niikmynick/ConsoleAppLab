package utils

import collection.CollectionManager
import commands.CommandInvoker
import commands.CommandReceiver
import commands.consoleCommands.*
import exceptions.InvalidInputException

/**
 * Class that handles commands and provides them all needed parameters
 * @property properties Contains system properties
 * @property commandInvoker See [CommandInvoker]
 * @property fileManager Used for loading data to collection
 * @property collection Current collection
 */
class Console {
    private val properties = System.getProperties()
    private val outputManager = OutputManager()
    private val inputManager = InputManager(outputManager)
    private val fileManager = FileManager(properties, outputManager)


    private val collectionManager = CollectionManager()

    private val commandInvoker = CommandInvoker(outputManager)
    private val commandReceiver = CommandReceiver(commandInvoker, collectionManager, outputManager, inputManager)

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
        commandInvoker.register("exit", Exit(commandReceiver))
        commandInvoker.register("add_if_min", AddMin(commandReceiver))
        commandInvoker.register("remove_greater", RemoveGreater(commandReceiver))
        commandInvoker.register("remove_lower", RemoveLower(commandReceiver))
        commandInvoker.register("remove_any_by_chapter", RemoveAnyChapter(commandReceiver))
        commandInvoker.register("count_by_melee_weapon", CountByMeleeWeapon(commandReceiver))
        commandInvoker.register("filter_by_chapter", FilterByChapter(commandReceiver))

        commandInvoker.register("help", Help(commandReceiver))

        fileManager.load(collectionManager.getCollection())
    }
    fun startInteractiveMode() {
        var executeFlag:Boolean? = true
        outputManager.surePrint("Waiting for user prompt ...")

        do {
            outputManager.print("$ ")
            try {
                val query = inputManager.read().trim().split(" ")
                if (query[0] != "") {
                    commandInvoker.executeCommand(query)
                    executeFlag = commandInvoker.getCommandMap()[query[0]]?.getExecutionFlag()
                }
            } catch (e: InvalidInputException) {
                outputManager.surePrint(e.message)
                break
            }
            catch (e:Exception) {
                outputManager.surePrint(e.message.toString())
            }
        } while (executeFlag != false)
    }
}
