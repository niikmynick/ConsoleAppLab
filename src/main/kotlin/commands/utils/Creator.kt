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
class Creator(private val outputManager: OutputManager, private val inputManager: InputManager) {
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

    /**
     * Creates and returns a new [Chapter] object
     * @return [Chapter] from entered values
     */
    fun createChapter() : Chapter {
        val name:String = stringReader.read("Enter name of the Chapter: ")
        val marinesCount: Long = longReader.read("Enter amount of Space Marines: ", 0, 1000)

        return Chapter(name, marinesCount)
    }

    /**
     * Creates and returns a new [Coordinates] object
     * @return [Coordinates] from entered values
     */
    fun createCoordinates() : Coordinates {
        val x: Double = doubleReader.read("Enter value of X: ")
        val y: Int = intReader.read("Enter value of Y: ")

        return Coordinates(x, y)
    }
}
