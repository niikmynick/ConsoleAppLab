package commands

import basicClasses.Chapter
import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
import collection.CollectionManager
import commands.consoleCommands.Command
import commands.utils.Creator
import commands.utils.Saver
import commands.utils.readers.EnumReader
import exceptions.InvalidArgumentException
import utils.InputManager
import utils.OutputManager

class CommandReceiver(private val commandInvoker: CommandInvoker,
                      private val collectionManager: CollectionManager,
                      private val outputManager: OutputManager,
                      private val inputManager: InputManager) {

    private val creator = Creator(outputManager, inputManager)

    /**
     * Gets a command map from [commandInvoker], and prints each command's info or info of provided command in [args]
     */
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
                    commandInvoker.getCommandMap().forEach { (name: String?, command: Command) -> outputManager.println(name.uppercase() + " - " + command.getInfo()) }
                } else {
                    outputManager.println(list[args[1].lowercase()]?.getInfo().toString())
                }
            }
        }
    }

    /**
     * Prints retrieved info from [collectionManager]
     */
    fun info() {
        outputManager.println(collectionManager.getInfo())
    }

    /**
     * Prints each element in [collectionManager]
     */
    fun show() {
        for (i in collectionManager.show()) {
            outputManager.println(i)
        }
    }

    fun add() {
        val spaceMarine = creator.createSpaceMarine()
        collectionManager.add(spaceMarine)
        outputManager.println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
    }
    /**
     * Creates new Space Marine and add it into collection
     */
    fun add(args: List<String>) {
        val spaceMarine = creator.createSpaceMarine(args)
        if (spaceMarine != null) {
            collectionManager.add(spaceMarine)
            outputManager.println("Space Marine ${spaceMarine.getName()} has been created and added to the collection")
        } else {
            throw InvalidArgumentException("Entered invalid argument")
        }
    }

    /**
     * Searches for a Space Marine with provided id and updates its values
     */
    fun updateByID(id:String) {
        try {
            val oldSpaceMarine = collectionManager.getByID(id.toLong())

            if (oldSpaceMarine != null) {
                val newSpaceMarine = creator.createSpaceMarine()
                collectionManager.update(oldSpaceMarine, newSpaceMarine)
                outputManager.println("Space Marine with id == $id was updated")
            } else {
                outputManager.println("Space Marine with id == $id does not exist")
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
                outputManager.println("Space Marine with id == $id does not exist")
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
            Saver(outputManager).save(filepath, collectionManager)
            outputManager.println("Collection was saved successfully")
        } catch (e:Exception) {
            outputManager.println(e.toString())
        }
    }

    fun executeScript(filepath: String) {
        inputManager.startScriptReader(filepath)
    }

    fun addMin() {
        val spaceMarine = creator.createSpaceMarine()

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
            outputManager.println("Space Marine with id == $id does not exist")
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
            outputManager.println("Space Marine with id == $id does not exist")
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
        val chapter = creator.createChapter()
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
        val weapon = EnumReader(outputManager, inputManager).read<MeleeWeapon>("Enter Weapon category from the list: ", true)
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
        val chapter = creator.createChapter()

        for (i in collectionManager.filter { e -> e.getChapter()!! == chapter }) {
            outputManager.println(i.toString())
        }
    }
}