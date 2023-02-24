package utils

import commands.CommandInvoker
import commands.consoleCommands.*
import java.io.File
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
    companion object {
        private var countOfInstances = 0
    }

    init {
        countOfInstances++
        File("collection$countOfInstances.yaml").createNewFile()
        System.setProperty("COLLECTION_FILENAME","collection$countOfInstances.yaml")
    }

    private val properties = System.getProperties()
    val commandInvoker = CommandInvoker()
    private val fileManager = FileManager(properties)
    val collection = CollectionManager()
    val scanner = Scanner(System.`in`)

    /**
     * Registers commands and waits for user prompt
     */
    fun initialize() {
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
    }
    fun startInteractiveMode() {
        println("Waiting for user prompt ...")
        var command:String
        do {
            print("$ ")
            command = readln().trim().lowercase()
            commandInvoker.executeCommand(command, scanner)
        } while (command != "exit")
    }
}
