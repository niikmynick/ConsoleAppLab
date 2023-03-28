package commands.utils

import basicClasses.*
import commands.utils.readers.*
import utils.InputManager
import utils.OutputManager

/**
 * Creator
 *
 * @constructor Create Creator
 */
class Creator(private val outputManager: OutputManager, inputManager: InputManager) {
    private val stringReader = StringReader(outputManager, inputManager)
    private val booleanReader = BooleanReader(outputManager, inputManager)
    private val floatReader = FloatReader(outputManager, inputManager)
    private val enumReader = EnumReader(outputManager, inputManager)
    private val longReader = LongReader(outputManager, inputManager)
    private val intReader = IntReader(outputManager, inputManager)
    private val doubleReader = DoubleReader(outputManager, inputManager)

    /**
     * provides to readers/creators. Then creates a Space Marine with user prompt
     *
     * @return [SpaceMarine] object
     */
    fun createSpaceMarine(): SpaceMarine {
        val name = stringReader.read("Enter name of the new Space Marine: ")
        val coordinates = createCoordinates()
        val health = floatReader.read("Enter health value (\\null for null value): ", true)
        val loyal = booleanReader.read("Enter loyalty [true / false]: ")
        val category = enumReader.read<AstartesCategory>("Enter Astartes category from the list: ", false)
        val weapon = enumReader.read<MeleeWeapon>("Enter Weapon category from the list: ", true)
        val chapter = createChapter()

        return SpaceMarine(name, coordinates, health, loyal, category!!, weapon, chapter)
    }

    fun createSpaceMarine(args:List<String>): SpaceMarine? {
        try {
            val name = args[1].trim()
            val coordinates = createCoordinates(args[2].trim().toDouble(), args[3].trim().toInt())
            val health = args[4].trim().toFloat()
            val loyal = args[5].toBooleanStrict()

            val category = enumValueOf<AstartesCategory>(args[6].uppercase())

            val weapon = enumValueOf<MeleeWeapon>(args[7].uppercase())

            val chapter = createChapter(args[8], args[9].toLong())

            return SpaceMarine(name, coordinates, health, loyal, category, weapon, chapter)

        } catch (e:Exception) {
            outputManager.println("entered invalid ")
            return null
        }
    }

    /**
     * Creates and returns a new [Chapter] object
     * @return [Chapter] from entered values
     */
    fun createChapter() : Chapter {
        val name:String = stringReader.read("Enter name of the Chapter: ")
        val marinesCount: Long = longReader.read("Enter amount of Space Marines: ", 0, 1000)

        return Chapter(name, marinesCount)
    }
    private fun createChapter(name:String, marinesCount:Long) : Chapter {
        return Chapter(name, marinesCount)
    }

    /**
     * Creates and returns a new [Coordinates] object
     * @return [Coordinates] from entered values
     */
    private fun createCoordinates() : Coordinates {
        val x: Double = doubleReader.read("Enter value of X: ")
        val y: Int = intReader.read("Enter value of Y: ")

        return Coordinates(x, y)
    }
    private fun createCoordinates(x:Double, y:Int) : Coordinates {
        return Coordinates(x, y)
    }
}
