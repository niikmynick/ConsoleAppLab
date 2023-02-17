package utils.readers

import basicClasses.SpaceMarine
import exceptions.SpaceMarineHealthLowerThanZero

class LoyaltyReader {
    companion object {
        fun read() : Boolean {
            println("Enter loyalty [true / false]: ")
            var loyalty: Boolean? = null
            do {
                try {
                    loyalty = readln().trim().lowercase().toBooleanStrict()
                } catch (e: Exception) {
                    println("You need to enter Boolean-type value of loyalty: ")
                }
            } while (loyalty == null)

            return loyalty
        }

        fun update(element: SpaceMarine) {
            println("Enter loyalty [true / false] (press enter to save existing parameter): ")
            var str: String? = null
            do {
                str = readln().trim()
                if (str.isNotEmpty()) {
                    try {
                        str.lowercase().toBooleanStrict()
                    } catch (e: Exception) {
                        println("You need to enter Boolean-type value of loyalty: ")
                        str = null
                    }
                }
            } while (str == null)

            if (str.isNotEmpty()) {
                element.setLoyal(str.lowercase().toBooleanStrict())
            }
        }
    }
}