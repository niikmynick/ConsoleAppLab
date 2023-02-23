package utils.readers

import basicClasses.Coordinates
import basicClasses.SpaceMarine
import java.util.Scanner

/**
 * Class containing readers for [Coordinates]
 */
class CoordinatesCreator {
    companion object {
        /**
         * Creates and returns a new [Coordinates] object
         * @param sc Is where a new line is gotten
         * @return [Coordinates] from entered values
         */
        fun create(sc:Scanner) : Coordinates {
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

        /**
         * Sets a new [Coordinates] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun update(element: SpaceMarine, sc:Scanner) {
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