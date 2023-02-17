package utils.readers

import basicClasses.Coordinates
import basicClasses.SpaceMarine

class CoordinatesCreator {
    companion object {
        fun create() : Coordinates {
            println("Enter value of X: ")
            var x : Double? = null
            do {
                try {
                    x = readln().trim().toDouble()
                } catch (e: Exception) {
                    println("You need to enter Double-type value of X .. ")
                }
            } while (x == null)


            println("Enter value of Y: ")
            var y : Long? = null
            do {
                try {
                    y = readln().trim().toLong()
                } catch (e: Exception) {
                    println("You need to enter Long-type value of Y: ")
                }
            } while (y == null)

            return Coordinates(x, y)
        }

        fun update(element: SpaceMarine) {
            println("Enter value of X (press enter to save existing parameter): ")
            var x: String? = null
            do {
                x = readln().trim()
                if (x.isNotEmpty()) {
                    try {
                        x.toDouble()
                    } catch (e: Exception) {
                        println("You need to enter Double-type value of X .. ")
                        x = null
                    }
                }
            } while (x == null)

            if (x.isNotEmpty()) {
                element.getCoordinates().setX(x.toDouble())
            }

            println("Enter value of Y (press enter to save existing parameter): ")
            var y: String? = null
            do {
                y = readln().trim()
                if (y.isNotEmpty()) {
                    try {
                        y.toLong()
                    } catch (e: Exception) {
                        println("You need to enter Long-type value of Y: ")
                        y = null
                    }
                }
            } while (y == null)

            if (y.isNotEmpty()) {
                element.getCoordinates().setY(y.toLong())
            }
        }
    }
}