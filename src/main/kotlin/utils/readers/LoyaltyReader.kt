package utils.readers

import basicClasses.SpaceMarine
import java.util.*

class LoyaltyReader {
    companion object {
        fun read(sc: Scanner) : Boolean {
            print("Enter loyalty [true / false]: ")
            var loyalty: Boolean? = null
            do {
                try {
                    loyalty = sc.nextLine().trim().lowercase().toBooleanStrict()
                } catch (e: Exception) {
                    print("You need to enter Boolean-type value of loyalty: ")
                }
            } while (loyalty == null)

            return loyalty
        }

        fun update(element: SpaceMarine, sc:Scanner) {
            print("Enter loyalty [true / false] (press enter to save existing parameter): ")
            var str: String?
            do {
                str = sc.nextLine().trim()
                if (str.isNotEmpty()) {
                    try {
                        str.lowercase().toBooleanStrict()
                    } catch (e: Exception) {
                        print("You need to enter Boolean-type value of loyalty: ")
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