package utils.readers

import basicClasses.SpaceMarine

class NameReader {
    companion object {
        fun read(): String {
            print("Enter name of the new Space Marine: ")
            var name:String = readln().trim()

            while (name.isEmpty()) {
                print("You need to enter the name: ")
                name = readln().trim()
            }

            return name
        }

        fun update(element: SpaceMarine) {
            print("Enter new name for Space Marine (press enter to save existing parameter): ")
            val string: String = readln()
            if (string.isNotEmpty()) {
                element.setName(string.trim())
            }
        }
    }
}
