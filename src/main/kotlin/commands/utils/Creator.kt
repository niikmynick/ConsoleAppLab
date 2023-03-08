package commands.utils

import basicClasses.Chapter
import basicClasses.Coordinates
import basicClasses.SpaceMarine
import commands.utils.readers.*
import exceptions.MarinesCountValueError

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
        fun createSpaceMarine(): SpaceMarine {
            val name = StringReader.read("Enter name of the new Space Marine: ")
            val coordinates = createCoordinates()
            val health = FloatReader.read("Enter health value (\\null for null value): ", true)
            val loyal = BooleanReader.read("Enter loyalty [true / false]: ")
            val category = CategoryReader.read()
            val weapon = WeaponReader.read()
            val chapter = createChapter()

            return SpaceMarine(name, coordinates, health, loyal, category, weapon, chapter)
        }


        /**
         * Creates and returns a new [Chapter] object
         * @return [Chapter] from entered values
         */
        fun createChapter() : Chapter {
            val name:String = StringReader.read("Enter name of the Chapter: ")
            val marinesCount: Long = LongReader.read("Enter amount of Space Marines: ", 0, 1000)

            return Chapter(name, marinesCount)
        }

        /**
         * Creates and returns a new [Coordinates] object
         * @return [Coordinates] from entered values
         */
        fun createCoordinates() : Coordinates {
            val x: Double = DoubleReader.read("Enter value of X: ")
            val y: Int = IntReader.read("Enter value of Y: ")

            return Coordinates(x, y)
        }
    }
}
