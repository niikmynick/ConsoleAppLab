package utils

import collection.CollectionManager
import commands.CommandInvoker
import commands.CommandReceiver
import commands.consoleCommands.*
import java.io.IOException
import java.util.Scanner

/**
 * Class that handles commands and provides them all needed parameters
 * @property properties Contains system properties
 * @property commandInvoker See [CommandInvoker]
 * @property fileManager Used for loading data to collection
 * @property collection Current collection
 * @property scanner Set to [System.in]
 */
class Console {
    private val properties = System.getProperties()
    private val fileManager = FileManager(properties)
    private val commandInvoker = CommandInvoker()
    private val collectionManager = CollectionManager()
    private val outputManager = OutputManager(System.out)
    private val commandReceiver = CommandReceiver(commandInvoker, collectionManager, outputManager)
    val scanner = Scanner(System.`in`)

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
        println("Waiting for user prompt ...")

        do {
            print("$ ")
            try {
                val query = scanner.nextLine().trim().split(" ")
                commandInvoker.executeCommand(query)
                executeFlag = commandInvoker.getCommandMap()[query[0]]?.getExecutionFlag()
            } catch (e:IOException) {
                println(e.message)
            }
        } while (executeFlag != false)
    }
}
