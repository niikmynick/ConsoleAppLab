package utils.readers

import basicClasses.SpaceMarine
import java.util.Scanner

class NameReader {
    companion object {
        fun read(sc:Scanner): String {
            print("Enter name of the new Space Marine: ")
            var name:String = sc.nextLine().trim()

            while (name.isEmpty()) {
                print("You need to enter the name: ")
                name = sc.nextLine().trim()
            }

            return name
        }

        fun update(element: SpaceMarine, sc:Scanner) {
            print("Enter new name for Space Marine (press enter to save existing parameter): ")
            val string: String = sc.nextLine()
            if (string.isNotEmpty()) {
                element.setName(string.trim())
            }
        }
    }
}
