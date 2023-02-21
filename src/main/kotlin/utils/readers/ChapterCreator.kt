package utils.readers

import basicClasses.Chapter
import basicClasses.SpaceMarine
import exceptions.MarinesCountValueError

/**
 * Chapter creator
 *
 * @constructor Create  Chapter creator
 */
class ChapterCreator {
    companion object {
        fun create() : Chapter {
            print("Enter name of the Chapter: ")
            var name:String = readln().trim()

            while (name.isEmpty()) {
                println("You need to enter name of the Chapter: ")
                name = readln().trim()
            }

            print("Enter amount of Space Marines: ")
            var marinecount : Long = -1
            do {
                try {
                    marinecount = readln().trim().toLong()
                    if (marinecount !in 0..1000) throw MarinesCountValueError("Marine Count value is not within 0 and 1000")
                } catch (e: Exception) {
                    print("You need to enter Long-type value of Space Marines amount: ")
                }

            } while (marinecount !in 0..1000)

            return Chapter(name, marinecount)
        }
        fun update(element :SpaceMarine) {
            print("Enter name of the Chapter (press enter to save existing parameter): ")
            val name:String = readln()
            if (name.isNotEmpty()) {
                element.getChapter().setName(name.trim())
            }

            print("Enter amount of Space Marines (press enter to save existing parameter): ")


            var marinecount : String?
            do {
                marinecount = readln()
                if (marinecount.isNotEmpty()) {
                    try {
                        marinecount.trim().toLong()
                        if (marinecount.trim().toLong() !in 0..1000) throw MarinesCountValueError("Marine Count value is not within 0 and 1000")
                    } catch (e: Exception) {
                        print("You need to enter Long-type value of Space Marines amount: ")
                        marinecount = null
                    }
                }
            } while (marinecount == null)

            if (marinecount.isNotEmpty()) {
                element.getChapter().setMarinesCount(marinecount.trim().toLong())
            }

        }

    }
}