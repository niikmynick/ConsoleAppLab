package utils

import commands.CommandInvoker
import commands.consoleCommands.*

class Console {
    fun startInteractiveMode() {
        val commandInvoker = CommandInvoker()

        commandInvoker.register("info", Info())
        commandInvoker.register("show", Show())
        commandInvoker.register("add", Add())
        commandInvoker.register("update_id", Update())
        commandInvoker.register("remove_by_id", RemoveID())
        commandInvoker.register("clear", Clear())
        commandInvoker.register("save", Save())
        commandInvoker.register("execute_script", ScriptFromFile())
        commandInvoker.register("exit", Exit())
        commandInvoker.register("add_if_max", Add())
        commandInvoker.register("remove_greater", RemoveGreater())
        commandInvoker.register("remove_lower", RemoveLower())
        commandInvoker.register("average_of_health", HealthAverage())
        commandInvoker.register("group_counting_by_name", GroupsByName())
        commandInvoker.register("print_unique_melee_weapon", UniqueWeapons())
        commandInvoker.register("help", Help(commandInvoker.getCommandsList()))

        println("Waiting for user command ...")
        var command:String
        do {
            print("$ ")
            command = readln().trim()
            commandInvoker.executeCommand(command)
        } while (command != "exit")
    }
}