package commands

import basicClasses.Chapter
import collection.CollectionManager
import commands.consoleCommands.Command
import commands.utils.Creator
import commands.utils.Saver
import commands.utils.readers.WeaponReader
import utils.InputManager
import java.io.FileReader

/**
 * Contains logic of commands
 * @property commandInvoker Command handler
 * @property collectionManager Used for working with collection
 * @property inputManager All input comes from this
 * @property scriptsList Saves file names of all called scripts
 */
class CommandReceiver() {

    private lateinit var commandInvoker: CommandInvoker
    private lateinit var collectionManager: CollectionManager
    private lateinit var inputManager: InputManager
    constructor(commandInvoker: CommandInvoker, collectionManager: CollectionManager, inputManager: InputManager) : this() {
        this.commandInvoker = commandInvoker
        this.collectionManager = collectionManager
        this.inputManager = inputManager
    }

    val scriptsList = mutableSetOf<String>()

    /**
     * Gives string of all commands info or of a specific command
     * @param args contains the name of the command which info should be shown
     * @return
     */
    fun help(args:List<String>) : String{
        val list = commandInvoker.getCommandMap()
        var output = ""
        when (args.size) {
            1 -> {
                output += "Help is available for the following commands:\n"
                for (key in list.keys) {
                    output += "- ${key.uppercase()}\n"
                }
                output += "For information on a command, type HELP {command name}\n"
                output += "To get information about each available command, type HELP ALL\n"
            }
            2 -> {
                if (args[1].lowercase() == "all") {
                    commandInvoker.getCommandMap().forEach { (name: String?, command: Command) -> output += name + " - "+ command.getInfo() + "\n" }
                } else {
                    output += list[args[1].lowercase()]?.getInfo().toString()
                }
            }
            else -> output += "Too much arguments"
        }
        return output
    }

    fun info(): String {
        return collectionManager.info()
    }

    fun show() : String{
        return collectionManager.show()
    }

    fun add() : String{
        val spaceMarine = Creator.createSpaceMarine(inputManager)
        collectionManager.add(spaceMarine)
        return "Space Marine ${spaceMarine.getName()} has been created and added to the collection"
    }

    fun updateByID(id:String) : String{
        return try {
            val oldSpaceMarine = collectionManager.getByID(id.toLong())

            if (oldSpaceMarine != null) {
                val newSpaceMarine = Creator.createSpaceMarine(inputManager)
                collectionManager.update(oldSpaceMarine, newSpaceMarine)
                "Space Marine with id == $id was updated"
            } else {
                "Space Marine with id == $id does not exist"
            }

        } catch (e: NumberFormatException) {
            "Invalid argument entered"
        }
    }

    fun removeByID(id:String) : String{
        return try {
            val spaceMarine = collectionManager.getByID(id.toLong())

            if (spaceMarine != null) {
                collectionManager.remove(spaceMarine)
                "Space Marine ${spaceMarine.getName()} has been deleted"
            } else {
                "Space Marine with id == $id does not exist"
            }

        } catch (e: NumberFormatException) {
            "Invalid argument entered"
        }
    }

    fun clear() : String{
        return if (collectionManager.getCollection().size > 0) {
            collectionManager.clear()
            "Collection has been cleared"
        } else {
            "The collection is already empty"
        }
    }

    fun save(filepath:String) : String{
        return try {
            Saver().save(filepath, collectionManager)
            "Collection was saved successfully"
        } catch (e:Exception) {
            e.message.toString()
        }
    }

    fun executeScript(filepath: String) : String{
        var output = ""
        scriptsList.add(filepath)
        try {

            val file = FileReader(filepath)
            val commandsList:List<String> = file.readLines()
            file.close()

            var count = 0

            inputManager.addLines(commandsList)

            do {
                val query = inputManager.nextLine().trim().lowercase().split(" ")
                if ((query[0] == "execute_script") && (query[1] in scriptsList)) {
                    return "Command ${query[0]} ${query[1]} can cause a recursive call so process was stopped"
                } else if ((query[0] == "execute_script") && (query[1] !in scriptsList)){
                    scriptsList.add(query[1])
                    commandInvoker.executeCommand(query)
                    count += 1
                }
                else {
                    commandInvoker.executeCommand(query)
                    count += 1
                }
            } while (inputManager.hasNextLine())

            output += when (count) {
                0 -> "The file does not contain commands"
                1 -> "1 command has been executed"
                else -> "$count commands have been executed"
            }

        } catch (e: Exception) {
            output += e.message.toString()
        }
        return output
    }

    fun exit() {
        //TODO()
    }

    /**
     * Adds an element if it is lower than the lowest element in collection
     */
    fun addMin() : String{
        val spaceMarine = Creator.createSpaceMarine(inputManager)

        return if (spaceMarine < collectionManager.getCollection().first()) {
            collectionManager.add(spaceMarine)
            "Space Marine ${spaceMarine.getName()} has been created and added to the collection"
        } else {
            "Space Marine ${spaceMarine.getName()} has not been added to the collection"
        }
    }

    /**
     * Removes all elements greater than provided
     */
    fun removeGreater(id: String) : String{
        val collection = collectionManager.getCollection()
        val spaceMarine = collectionManager.getByID(id.toLong())

        var count = 0

        return if (spaceMarine == null)
            "Space Marine with id == $id does not exist"
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() > spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            "$count Space Marines have been deleted"
        }
    }

    /**
     * Removes all elements lower than provided
     */
    fun removeLower(id: String) : String{
        val collection = collectionManager.getCollection()
        val spaceMarine = collectionManager.getByID(id.toLong())

        var count = 0

        return if (spaceMarine == null)
            "Space Marine with id == $id does not exist"
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() < spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            "$count Space Marines have been deleted"
        }
    }

    /**
     * Removes first found element with [Chapter] equal to provided
     */
    fun removeByChapter() : String{
        val chapter = Creator.createChapter(inputManager)
        val collection = collectionManager.getCollection()

        for (spaceMarine in collection) {
            if (spaceMarine.getChapter() == chapter) {
                collectionManager.remove(spaceMarine)
                return "A Space Marine with Chapter == $chapter has been removed"
            }
        }

        return "No Space Marine with chapter == $chapter was found"
    }

    fun countByWeapon() : String{
        val weapon = WeaponReader.read(inputManager)
        val collection = collectionManager.getCollection()
        var count = 0

        return if (collection.isNotEmpty()) {
            for (spaceMarine in collection) {
                if (spaceMarine.getWeapon() == weapon) {
                    count++
                }
            }
            when (count) {
                0 -> "No MeleeWeapon named ${weapon.name} was found\n"
                1 -> "Only 1 Space Marine with weapon $weapon found"
                else -> "$count Space Marines with weapon $weapon found"
            }
        } else {
            "The collection is empty"
        }
    }

    fun filterByChapter() : String{
        val chapter = Creator.createChapter(inputManager)
        return collectionManager.filterByChapter(chapter)
    }
}