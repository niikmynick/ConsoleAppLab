package utils.readers

import basicClasses.SpaceMarine
import exceptions.SpaceMarineHealthLowerThanZero

/**
 * Health reader
 *
 * @constructor Create Health reader
 */
class HealthReader {
    companion object {
        fun read(): Float {
            print("Enter health value: ")
            var health = 0F
            do {
                try {
                    health = readln().trim().toFloat()
                    if (health <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be lower than zero")
                } catch (e: Exception) {
                    print("You need to enter Float-type value of health > 0: ")
                }

            } while (health <= 0)

            return health
        }
        fun update(element: SpaceMarine) {
            print("Enter new health value (press enter to save existing parameter): ")
            var str: String?
            do {
                str = readln()
                if (str.isNotEmpty()) {
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