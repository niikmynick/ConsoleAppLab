package commands

import basicClasses.Chapter
import basicClasses.MeleeWeapon
import collection.CollectionManager
import commands.consoleCommands.Command
import commands.utils.Creator
import commands.utils.Saver
import commands.utils.Validator
import commands.utils.readers.EnumReader
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

class CommandReceiver() {

    private lateinit var commandInvoker: CommandInvoker
    private lateinit var collectionManager: CollectionManager
    constructor(commandInvoker: CommandInvoker, collectionManager: CollectionManager) : this() {
        this.commandInvoker = commandInvoker
        this.collectionManager = collectionManager
    }

    private var filesList:MutableList<String> = mutableListOf()

    fun help(args:List<String>) {
        val list = commandInvoker.getCommandMap()
        when (args.size) {
            1 -> {
                println("Help is available for the following commands:")
                for (key in list.keys) {
                    println("- ${key.uppercase()}")
                }
                println("For information on a command, type HELP {command name}")
                println("To get information about each available command, type HELP ALL")
            }
            2 -> {
                if (args[1].lowercase() == "all") {
                    commandInvoker.getCommandMap().forEach { (name: String?, command: Command) -> println(name + " - "+ command.getInfo()) }
                } else {
                    println(list[args[1].lowercase()]?.getInfo().toString())
                }
            }
        }
    }

    fun info() {
        collectionManager.printInfo()
    }

    fun show() {
        collectionManager.show()
    }

    fun add() {
        val spaceMarine = Creator.createSpaceMarine()
        collectionManager.add(spaceMarine)
        println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
    }

    fun updateByID(id:String) {
        try {
            val newSpaceMarine = Creator.createSpaceMarine()
            val oldSpaceMarine = collectionManager.getByID(id.toLong())

            if (oldSpaceMarine != null) {
                collectionManager.update(oldSpaceMarine, newSpaceMarine)
            } else {
                println("Space Marine with id == $id do not exist")
            }

        } catch (e: NumberFormatException) {
            println("Invalid argument entered")
        }
    }

    fun removeByID(id:String) {
        try {
            val spaceMarine = collectionManager.getByID(id.toLong())

            if (spaceMarine != null) {
                collectionManager.remove(spaceMarine)
                println("Space Marine ${spaceMarine.getName()} has been deleted")
            } else {
                println("Space Marine with id == $id do not exist")
            }

        } catch (e: NumberFormatException) {
            println("Invalid argument entered")
        }
    }

    fun clear() {
        if (collectionManager.getCollection().size > 0) {
            collectionManager.clear()
            println("Collection has been cleared")
        } else {
            println("The collection is already empty")
        }
    }

    fun save(filepath:String) {
        try {
            val collection = collectionManager.getCollection()
            Saver().save(filepath, collection)
            println("Collection was saved successfully")
        } catch (e:Exception) {
            TODO()
        }
    }

    fun executeScript(filepath: String) {
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

            when (count) {
                0 -> println("The file does not contain commands")
                1 -> println("1 command has been executed")
                else -> println("$count commands have been executed")
            }

        } catch (e:FileNotFoundException) {
            e.printStackTrace()
        } catch (e:IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun exit() {
        TODO()
    }

    fun addMin() {
        val spaceMarine = Creator.createSpaceMarine()

        if (spaceMarine < collectionManager.getCollection().first()) {
            collectionManager.add(spaceMarine)
            println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
        } else {
            println("Space Marine ${spaceMarine.getName()} has not been added to the collection")
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
            println("Space Marine with id == $id do not exist")
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() > spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            println("$count Space Marines have been deleted")
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
            println("Space Marine with id == $id do not exist")
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() < spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            println("$count Space Marines have been deleted")
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
                println("A Space Marine with Chapter == $chapter has been removed")
                break
            }
        }

        if (!flag) {
            println("No Space Marine with chapter == $chapter was found")
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
                0 -> println("No MeleeWeapon named $weapon was found")
                1 -> println("Only 1 Space Marine with weapon $weapon found")
                else -> println("$count Space Marines with weapon $weapon found")
            }
        } else {
            println("The collection is empty")
        }
    }

    fun filterByChapter() {
        val chapter = Creator.createChapter()
        collectionManager.filterByChapter(chapter)
    }
}