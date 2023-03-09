package commands.utils

import basicClasses.*
import commands.utils.readers.*

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
            val category = EnumReader.read<AstartesCategory>("Enter Astartes category from the list: ", false)
            val weapon = EnumReader.read<MeleeWeapon>("Enter Weapon category from the list: ", true)
            val chapter = createChapter()

            return SpaceMarine(name, coordinates, health, loyal, category!!, weapon, chapter)
        }

        fun createScriptMarine(parameters: ArrayList<String>): SpaceMarine {
            return SpaceMarine(parameters[0], Coordinates(parameters[1].toDouble(), parameters[2].toInt()), parameters[3].toFloat(), parameters[4].toBooleanStrict(), enumValueOf<AstartesCategory>(parameters[5].uppercase()), enumValueOf<MeleeWeapon>(parameters[6].uppercase()), Chapter(parameters[7],parameters[8].toLong()))
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
