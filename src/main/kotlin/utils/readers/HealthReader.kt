package utils.readers

import basicClasses.SpaceMarine
import exceptions.SpaceMarineHealthLowerThanZero
import java.util.Scanner

/**
 * Health reader
 *
 * Class containing readers for [SpaceMarine.health]
 *
 * @constructor Create Health reader
 */
class HealthReader {
    companion object {
        /**
         * Reads and gives a valid [SpaceMarine.health] value
         * @param sc Is where a new line is gotten
         * @return [SpaceMarine.health] value
         */
        fun read(sc: Scanner): Float? {
            print("Enter health value (\\null for null value): ")
            var health = 0F
            do {
                try {
                    val str = sc.nextLine()
                    if (str == "\\null") {
                        return null
                    } else {
                        health = str.trim().toFloat()
                    }

                    if (health <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be lower than zero")
                } catch (e: Exception) {
                    print("You need to enter Float-type value of health > 0: ")
                }

            } while (health <= 0)

            return health
        }
        /**
         * Sets a new [SpaceMarine.health] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun update(element: SpaceMarine, sc:Scanner) {
            print("Enter new health value (press enter to save existing parameter, \\null for null value): ")
            var str: String?
            do {
                str = sc.nextLine()
                if (str.isNotEmpty()) {
                    if (str == "\\null") {
                        element.setHealth(null)
                        return
                    }
                    try {
                        str.trim().toFloat()
                        if (str.toFloat() <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be lower than zero")
                    } catch (e: Exception) {
                        print("You need to enter Int-type value of health > 0: ")
                        str = null
                    }
                }
            } while (str == null)

            if (str.isNotEmpty()) {
                element.setHealth(str.trim().toFloat())
            }
        }
    }
}