package commands.utils

import basicClasses.Chapter
import basicClasses.Coordinates
import basicClasses.SpaceMarine
import exceptions.MarinesCountValueError
import java.util.*

/**
 * Updater
 *
 * @constructor Create Updater
 */
class Updater {
    companion object {
        /**
         * Sets a new [Chapter] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun updateChapter(element : SpaceMarine, sc: Scanner) {
            print("Enter name of the Chapter (press enter to save existing parameter): ")
            val name:String = sc.nextLine()
            if (name.isNotEmpty()) {
                element.getChapter().setName(name.trim())
            }

            print("Enter amount of Space Marines (press enter to save existing parameter): ")


            var marinecount : String?
            do {
                marinecount = sc.nextLine()
                if (marinecount.isNotEmpty()) {
                    try {
                        marinecount.trim().toLong()
                        if (marinecount.trim().toLong() !in 0..1000) throw MarinesCountValueError("Marine Count value is not within 0 and 1000")
                    } catch (e: Exception) {
                        print("You need to enter a Long-type value between 0 and 1000: ")
                        marinecount = null
                    }
                }
            } while (marinecount == null)

            if (marinecount.isNotEmpty()) {
                element.getChapter().setMarinesCount(marinecount.trim().toLong())
            }

        }

        /**
         * Sets a new [Coordinates] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun updateCoordinates(element: SpaceMarine, sc:Scanner) {
            print("Enter value of X (press enter to save existing parameter): ")
            var x: String?
            do {
                x = sc.nextLine().trim()
                if (x.isNotEmpty()) {
                    try {
                        x.toDouble()
                    } catch (e: Exception) {
                        print("You need to enter Double-type value of X .. ")
                        x = null
                    }
                }
            } while (x == null)

            if (x.isNotEmpty()) {
                element.getCoordinates().setX(x.toDouble())
            }

            print("Enter value of Y (press enter to save existing parameter): ")
            var y: String?
            do {
                y = sc.nextLine().trim()
                if (y.isNotEmpty()) {
                    try {
                        y.toInt()
                    } catch (e: Exception) {
                        print("You need to enter Int-type value of Y: ")
                        y = null
                    }
                }
            } while (y == null)

            if (y.isNotEmpty()) {
                element.getCoordinates().setY(y.toInt())
            }
        }
    }
}