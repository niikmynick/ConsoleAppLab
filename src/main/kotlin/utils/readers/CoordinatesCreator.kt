package utils.readers

import basicClasses.Coordinates
import basicClasses.SpaceMarine

/**
 * Coordinates creator
 *
 * @constructor Create Coordinates creator
 */
class CoordinatesCreator {
    companion object {
        fun create() : Coordinates {
            print("Enter value of X: ")
            var x : Double? = null
            do {
                try {
                    x = readln().trim().toDouble()
                } catch (e: Exception) {
                    print("You need to enter Double-type value of X .. ")
                }
            } while (x == null)


            print("Enter value of Y: ")
            var y : Int? = null
            do {
                try {
                    y = readln().trim().toInt()
                } catch (e: Exception) {
                    print("You need to enter Int-type value of Y: ")
                }
            } while (y == null)

            return Coordinates(x, y)
        }

        fun update(element: SpaceMarine) {
            print("Enter value of X (press enter to save existing parameter): ")
            var x: String?
            do {
                x = readln().trim()
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
                y = readln().trim()
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