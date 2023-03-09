package commands

import basicClasses.Chapter
import basicClasses.MeleeWeapon
import collection.CollectionManager
import commands.consoleCommands.Command
import commands.utils.Creator
import commands.utils.Saver
import commands.utils.Validator
import commands.utils.readers.EnumReader
import utils.OutputManager
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

class CommandReceiver() {

    private lateinit var commandInvoker: CommandInvoker
    private lateinit var collectionManager: CollectionManager
    private lateinit var outputManager: OutputManager
    constructor(commandInvoker: CommandInvoker, collectionManager: CollectionManager, outputManager: OutputManager) : this() {
        this.commandInvoker = commandInvoker
        this.collectionManager = collectionManager
        this.outputManager = outputManager
    }

    private var filesList:MutableList<String> = mutableListOf()

    fun help(args:List<String>) {
        val list = commandInvoker.getCommandMap()
        when (args.size) {
            1 -> {
                outputManager.println("Help is available for the following commands:")
                for (key in list.keys) {
                    outputManager.println("- ${key.uppercase()}")
                }
                outputManager.println("For information on a command, type HELP {command name}")
                outputManager.println("To get information about each available command, type HELP ALL")
            }
            2 -> {
                if (args[1].lowercase() == "all") {
                    commandInvoker.getCommandMap().forEach { (name: String?, command: Command) -> outputManager.println(name + " - "+ command.getInfo()) }
                } else {
                    outputManager.println(list[args[1].lowercase()]?.getInfo().toString())
                }
            }
        }
    }

    fun info() {
        outputManager.println(collectionManager.getInfo())
    }

    fun show() {
        for (i in collectionManager.show()) {
            outputManager.println(i)
        }
    }

    fun add() {
        val spaceMarine = Creator.createSpaceMarine()
        collectionManager.add(spaceMarine)
        outputManager.println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
    }

    fun updateByID(id:String) {
        try {
            val newSpaceMarine = Creator.createSpaceMarine()
            val oldSpaceMarine = collectionManager.getByID(id.toLong())

            if (oldSpaceMarine != null) {
                collectionManager.update(oldSpaceMarine, newSpaceMarine)
            } else {
                outputManager.println("Space Marine with id == $id do not exist")
            }

        } catch (e: NumberFormatException) {
            outputManager.println("Invalid argument entered")
        }
    }

    fun removeByID(id:String) {
        try {
            val spaceMarine = collectionManager.getByID(id.toLong())

            if (spaceMarine != null) {
                collectionManager.remove(spaceMarine)
                outputManager.println("Space Marine ${spaceMarine.getName()} has been deleted")
            } else {
                outputManager.println("Space Marine with id == $id do not exist")
            }

        } catch (e: NumberFormatException) {
            outputManager.println("Invalid argument entered")
        }
    }

    fun clear() {
        if (collectionManager.getCollection().size > 0) {
            collectionManager.clear()
            outputManager.println("Collection has been cleared")
        } else {
            outputManager.println("The collection is already empty")
        }
    }

    fun save(filepath:String) {
        try {
            val collection = collectionManager.getCollection()
            Saver().save(filepath, collection)
            outputManager.println("Collection was saved successfully")
        } catch (e:Exception) {
            outputManager.println(e.toString())
        }
    }

    fun executeScript(filepath: String) {
        outputManager.silentMode()
        try {
            filesList.add(filepath)

            val file = BufferedReader(FileReader(filepath))

            var line = file.readLine()
            var count = 0

            while (line != null) {
                val query: List<String> = line.trim().lowercase().split(" ")

                if ((query[0] == "add") || (query[0] == "update")) {
                    val parameters = ArrayList<String>()

                    for (i in 0..8) {
                        line = file.readLine()
                        if (line != null) {
                            parameters.add(line.trim())
                        } else {
                            println("You need to enter value")
                            break
                        }
                    }

                    if (Validator.verifyArray(parameters)) {
                        val newSpaceMarine = Creator.createScriptMarine(parameters)

                        if (query[0] == "add") {
                            collectionManager.add(newSpaceMarine)
                            count += 1
                        } else {
                            val oldSpaceMarine = collectionManager.getByID(query[1].toLong())

                            if (oldSpaceMarine != null) {
                                collectionManager.update(oldSpaceMarine, newSpaceMarine)
                                count += 1
                            }
                        }
                    } else {
                        println("Entered parameters are incorrect")
                    }

                } else if (query[0] == "execute_script") {
                    if (query[1] in filesList) {
                        println("Command '$line' can cause a recursive call so process was stopped")
                        break
                    } else {
                        commandInvoker.executeCommand(query)
                        filesList += query[1]
                        count += 1
                    }
                } else {
                    commandInvoker.executeCommand(query)
                    count += 1
                }

                line = file.readLine()
            }

            file.close()
            outputManager.enableOutput()

            when (count) {
                0 -> outputManager.println("The file does not contain commands")
                1 -> outputManager.println("1 command has been executed")
                else -> outputManager.println("$count commands have been executed")
            }

            filesList.clear()

        } catch (e:FileNotFoundException) {
            outputManager.println(e.toString())
        } catch (e:IOException) {
            outputManager.println(e.toString())
        } catch (e: Exception) {
            outputManager.println(e.toString())
        }
    }

    fun addMin() {
        val spaceMarine = Creator.createSpaceMarine()

        if (spaceMarine < collectionManager.getCollection().first()) {
            collectionManager.add(spaceMarine)
            outputManager.println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
        } else {
            outputManager.println("Space Marine ${spaceMarine.getName()} has not been added to the collection")
        }
    }

    /**
     * Removes all elements greater than provided
     */
    fun removeGreater(id: String) {
        val collection = collectionManager.getCollection()
        val spaceMarine = collectionManager.getByID(id.toLong())

        var count = 0

        if (spaceMarine == null)
            outputManager.println("Space Marine with id == $id do not exist")
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() > spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            outputManager.println("$count Space Marines have been deleted")
        }
    }

    /**
     * Removes all elements lower than provided
     */
    fun removeLower(id: String) {
        val collection = collectionManager.getCollection()
        val spaceMarine = collectionManager.getByID(id.toLong())

        var count = 0

        if (spaceMarine == null)
            outputManager.println("Space Marine with id == $id do not exist")
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() < spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            outputManager.println("$count Space Marines have been deleted")
        }
    }

    /**
     * Removes first found element with [Chapter] equal to provided
     */
    fun removeByChapter() {
        val chapter = Creator.createChapter()
        val collection = collectionManager.getCollection()
        val flag = false

        for (spaceMarine in collection) {
            if (spaceMarine.getChapter() == chapter) {
                collectionManager.remove(spaceMarine)
                outputManager.println("A Space Marine with Chapter == $chapter has been removed")
                break
            }
        }

        if (!flag) {
            outputManager.println("No Space Marine with chapter == $chapter was found")
        }
    }

    fun countByWeapon() {
        val weapon = EnumReader.read<MeleeWeapon>("Enter Weapon category from the list: ", true)
        val collection = collectionManager.getCollection()
        var count = 0

        if (collection.isNotEmpty()) {
            for (spaceMarine in collection) {
                if (spaceMarine.getWeapon() == weapon) {
                    count++
                }
            }
            when (count) {
                0 -> outputManager.println("No MeleeWeapon named $weapon was found")
                1 -> outputManager.println("Only 1 Space Marine with weapon $weapon found")
                else -> outputManager.println("$count Space Marines with weapon $weapon found")
            }
        } else {
            outputManager.println("The collection is empty")
        }
    }

    fun filterByChapter() {
        val chapter = Creator.createChapter()
        for (i in collectionManager.filterByChapter(chapter)) {
            outputManager.println(i)
        }
    }
}