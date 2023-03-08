package commands

import basicClasses.Chapter
import collection.CollectionManager
import commands.consoleCommands.Command
import commands.utils.Creator
import commands.utils.Saver
import commands.utils.readers.WeaponReader
import utils.InputManager
import java.io.FileReader

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
        try {
            val oldSpaceMarine = collectionManager.getByID(id.toLong())

            if (oldSpaceMarine != null) {
                val newSpaceMarine = Creator.createSpaceMarine(inputManager)
                collectionManager.update(oldSpaceMarine, newSpaceMarine)
                return "Space Marine with id == $id was updated"
            } else {
                return "Space Marine with id == $id does not exist"
            }

        } catch (e: NumberFormatException) {
            return "Invalid argument entered"
        }
    }

    fun removeByID(id:String) : String{
        try {
            val spaceMarine = collectionManager.getByID(id.toLong())

            if (spaceMarine != null) {
                collectionManager.remove(spaceMarine)
                return "Space Marine ${spaceMarine.getName()} has been deleted"
            } else {
                return "Space Marine with id == $id does not exist"
            }

        } catch (e: NumberFormatException) {
            return "Invalid argument entered"
        }
    }

    fun clear() : String{
        if (collectionManager.getCollection().size > 0) {
            collectionManager.clear()
            return "Collection has been cleared"
        } else {
            return "The collection is already empty"
        }
    }

    fun save(filepath:String) : String{
        try {
            Saver().save(filepath, collectionManager)
            return "Collection was saved successfully"
        } catch (e:Exception) {
            return e.message.toString()
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

            when (count) {
                0 ->  output += "The file does not contain commands"
                1 -> output += "1 command has been executed"
                else -> output += "$count commands have been executed"
            }

        } catch (e: Exception) {
            output += e.message.toString()
        }
        return output
    }

    fun exit() {
        TODO()
    }

    fun addMin() : String{
        val spaceMarine = Creator.createSpaceMarine(inputManager)

        if (spaceMarine < collectionManager.getCollection().first()) {
            collectionManager.add(spaceMarine)
            return "Space Marine ${spaceMarine.getName()} has been created and added to the collection"
        } else {
            return "Space Marine ${spaceMarine.getName()} has not been added to the collection"
        }
    }

    /**
     * Removes all elements greater than provided
     */
    fun removeGreater(id: String) : String{
        val collection = collectionManager.getCollection()
        val spaceMarine = collectionManager.getByID(id.toLong())

        var count = 0

        if (spaceMarine == null)
            return "Space Marine with id == $id does not exist"
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() > spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            return "$count Space Marines have been deleted"
        }
    }

    /**
     * Removes all elements lower than provided
     */
    fun removeLower(id: String) : String{
        val collection = collectionManager.getCollection()
        val spaceMarine = collectionManager.getByID(id.toLong())

        var count = 0

        if (spaceMarine == null)
            return "Space Marine with id == $id does not exist"
        else {
            while (collection.isNotEmpty()) {
                if (collection.last() < spaceMarine) {
                    collectionManager.remove(collection.last())
                    count++
                }
            }
            return "$count Space Marines have been deleted"
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

        if (collection.isNotEmpty()) {
            for (spaceMarine in collection) {
                if (spaceMarine.getWeapon() == weapon) {
                    count++
                }
            }
            when (count) {
                0 -> return "No MeleeWeapon named ${weapon.name} was found\n"
                1 -> return "Only 1 Space Marine with weapon $weapon found"
                else -> return "$count Space Marines with weapon $weapon found"
            }
        } else {
            return "The collection is empty"
        }
    }

    fun filterByChapter() : String{
        val chapter = Creator.createChapter(inputManager)
        return collectionManager.filterByChapter(chapter)
    }
}