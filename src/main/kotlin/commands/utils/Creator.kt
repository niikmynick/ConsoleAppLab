package commands.utils

import basicClasses.Chapter
import basicClasses.Coordinates
import basicClasses.SpaceMarine
import commands.utils.readers.*
import utils.InputManager

/**
 * Creator
 *
 * @constructor Create Creator
 */
class Creator {
    companion object {
        /**
         * provides to readers/creators. Then creates a Space Marine with user prompt
         *
         * @return [SpaceMarine] object
         */
        fun createSpaceMarine(inputManager: InputManager): SpaceMarine {
            val name = StringReader.read("Enter name of the new Space Marine: ", inputManager)
            val coordinates = createCoordinates(inputManager)
            val health = FloatReader.read("Enter health value (\\null for null value): ", true, inputManager)
            val loyal = BooleanReader.read("Enter loyalty [true / false]: ", inputManager)
            val category = CategoryReader.read(inputManager)
            val weapon = WeaponReader.read(inputManager)
            val chapter = createChapter(inputManager)

            return SpaceMarine(name, coordinates, health, loyal, category, weapon, chapter)
        }


        /**
         * Creates and returns a new [Chapter] object
         * @return [Chapter] from entered values
         */
        fun createChapter(inputManager: InputManager) : Chapter {
            val name:String = StringReader.read("Enter name of the Chapter: ", inputManager)
            val marinesCount: Long = LongReader.read("Enter amount of Space Marines: ", 0, 1000, inputManager)

            return Chapter(name, marinesCount)
        }

        /**
         * Creates and returns a new [Coordinates] object
         * @return [Coordinates] from entered values
         */
        fun createCoordinates(inputManager: InputManager) : Coordinates {
            val x: Double = DoubleReader.read("Enter value of X: ", inputManager)
            val y: Int = IntReader.read("Enter value of Y: ", inputManager)

            return Coordinates(x, y)
        }
    }
}
