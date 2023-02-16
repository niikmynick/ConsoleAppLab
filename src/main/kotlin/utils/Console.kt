package utils

import commands.CommandInvoker
import commands.consoleCommands.*
class Console {
    fun startInteractiveMode() {
        val commandInvoker = CommandInvoker()
        val collection = CollectionManager()

        var command:String

        commandInvoker.register("info", Info(collection))
        commandInvoker.register("show", Show(collection))
        commandInvoker.register("add", Add(collection))
        commandInvoker.register("update_id", Update(collection))
        commandInvoker.register("remove_by_id", RemoveID(collection))
        commandInvoker.register("clear", Clear(collection))
        commandInvoker.register("save", Save(collection))
        commandInvoker.register("execute_script", ScriptFromFile())
        commandInvoker.register("exit", Exit())
        commandInvoker.register("add_if_max", AddMax(collection))
        commandInvoker.register("remove_greater", RemoveGreater(collection))
        commandInvoker.register("remove_lower", RemoveLower(collection))
        commandInvoker.register("average_of_health", HealthAverage(collection))
        commandInvoker.register("group_counting_by_name", GroupsByName(collection))
        commandInvoker.register("print_unique_melee_weapon", UniqueWeapons(collection))

        commandInvoker.register("help", Help(commandInvoker.getCommandsList()))

        println("Waiting for the user command ...")
        do {
            print("$ ")
            command = readln().trim()
            commandInvoker.executeCommand(command)
        } while (command != "exit")
    }
}