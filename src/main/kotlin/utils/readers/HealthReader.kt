package utils.readers

import basicClasses.SpaceMarine
import exceptions.SpaceMarineHealthLowerThanZero

class HealthReader {
    companion object {
        fun read(): Int {
            println("Enter health value: ")
            var health : Int = 0
            do {
                try {
                    health = readln().trim().toInt()
                    if (health <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be lower than zero")
                } catch (e: Exception) {
                    println("You need to enter Int-type value of health > 0: ")
                }

            } while (health <= 0)

            return health
        }
        fun update(element: SpaceMarine) {
            println("Enter new health value (press enter to save existing parameter): ")
            var str: String? = null
            do {
                str = readln()
                if (str.isNotEmpty()) {
                    try {
                        str.trim().toInt()
                        if (str.toInt() <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be lower than zero")
                    } catch (e: Exception) {
                        println("You need to enter Int-type value of health > 0: ")
                        str = null
                    }
                }
            } while (str == null)

            if (str.isNotEmpty()) {
                element.setHealth(str.trim().toInt())
            }
        }
    }
}