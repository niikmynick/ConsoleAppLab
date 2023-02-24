package utils

import basicClasses.Chapter
import basicClasses.Coordinates
import basicClasses.SpaceMarine
import exceptions.MarinesCountValueError
import utils.readers.*
import java.util.Scanner

/**
 * Creator
 *
 * @constructor Create Creator
 */
class Creator {
    companion object {
        /**
         * Gets [sc] and provides to readers/creators. Then creates a Space Marine with user prompt
         *
         * @param sc Given to readers/creators
         * @return [SpaceMarine] object
         */
        fun createSpaceMarine(sc:Scanner): SpaceMarine {
            val name = NameReader.read(sc)
            val coordinates = createCoordinates(sc)
            val health = HealthReader.read(sc)
            val loyal = LoyaltyReader.read(sc)
            val category = CategoryReader.read(sc)
            val weapon = WeaponReader.read(sc)
            val chapter = createChapter(sc)

            return SpaceMarine(name, coordinates, health, loyal, category, weapon, chapter)
        }


        /**
         * Creates and returns a new [Chapter] object
         * @param sc Is where a new line is gotten
         * @return [Chapter] from entered values
         */
        fun createChapter(sc: Scanner) : Chapter {
            print("Enter name of the Chapter: ")
            var name:String = sc.nextLine().trim()

            while (name.isEmpty()) {
                println("You need to enter name of the Chapter: ")
                name = sc.nextLine().trim()
            }

            print("Enter amount of Space Marines: ")
            var marinesCount : Long = -1
            do {
                try {
                    marinesCount = sc.nextLine().trim().toLong()
                    if (marinesCount !in 0..1000) throw MarinesCountValueError("Marine Count value is not within 0 and 1000")
                } catch (e: Exception) {
                    print("You need to enter a Long-type value between 0 and 1000: ")
                }

            } while (marinesCount !in 0..1000)

            return Chapter(name, marinesCount)
        }

        /**
         * Creates and returns a new [Coordinates] object
         * @param sc Is where a new line is gotten
         * @return [Coordinates] from entered values
         */
        fun createCoordinates(sc:Scanner) : Coordinates {
            print("Enter value of X: ")
            var x : Double? = null
            do {
                try {
                    x = sc.nextLine().trim().toDouble()
                } catch (e: Exception) {
                    print("You need to enter Double-type value of X .. ")
                }
            } while (x == null)


            print("Enter value of Y: ")
            var y : Int? = null
            do {
                try {
                    y = sc.nextLine().trim().toInt()
                } catch (e: Exception) {
                    print("You need to enter Int-type value of Y: ")
                }
            } while (y == null)

            return Coordinates(x, y)
        }
    }
}
