package utils.readers

import basicClasses.SpaceMarine
import java.util.Scanner

/**
 * Name reader
 *
 * Class containing readers for [SpaceMarine.name]
 *
 * @constructor Create Name reader
 */
class NameReader {
    companion object {
        /**
         * Reads and gives a valid [SpaceMarine.name] value
         * @param sc Is where a new line is gotten
         * @return [SpaceMarine.name] value
         */
        fun read(sc:Scanner): String {
            print("Enter name of the new Space Marine: ")
            var name:String = sc.nextLine().trim()

            while (name.isEmpty()) {
                print("You need to enter the name: ")
                name = sc.nextLine().trim()
            }

            return name
        }

        /**
         * Sets a new [SpaceMarine.name] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun update(element: SpaceMarine, sc:Scanner) {
            print("Enter new name for Space Marine (press enter to save existing parameter): ")
            val string: String = sc.nextLine().trim()
            if (string.isNotEmpty()) {
                element.setName(string.trim())
            }
        }
    }
}
