package utils.readers

import basicClasses.Chapter
import basicClasses.SpaceMarine
import exceptions.MarineCountIllegalValue
import java.util.*

/**
 * Class containing readers for [Chapter]
 */
class ChapterCreator {
    companion object {
        /**
         * Creates and returns a new [Chapter] object
         * @param sc Is where a new line is gotten
         * @return [Chapter] from entered values
         */
        fun create(sc: Scanner) : Chapter {
            print("Enter name of the Chapter: ")
            var name:String = sc.nextLine().trim()

            while (name.isEmpty()) {
                println("You need to enter name of the Chapter: ")
                name = sc.nextLine().trim()
            }

            print("Enter amount of Space Marines: ")
            var marinecount : Long = -1
            do {
                try {
                    marinecount = sc.nextLine().trim().toLong()
                    if (marinecount !in 0..1000) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
                } catch (e: Exception) {
                    print("You need to enter a Long-type value between 0 and 1000: ")
                }

            } while (marinecount !in 0..1000)

            return Chapter(name, marinecount)
        }

        /**
         * Sets a new [Chapter] for provided element
         * @param element [SpaceMarine] object that is modified
         * @param sc Is where a new line is gotten
         */
        fun update(element :SpaceMarine, sc:Scanner) {
            print("Enter name of the Chapter (press enter to save existing parameter): ")
            val name:String = sc.nextLine()
            if (name.isNotEmpty()) {
                element.getChapter().setName(name.trim())
            }

            print("Enter amount of Space Marines (press enter to save existing parameter): ")


            var marinecount : String?
            do {
                marinecount = sc.nextLine()
                if (marinecount.isNotEmpty()) {
                    try {
                        marinecount.trim().toLong()
                        if (marinecount.trim().toLong() !in 0..1000) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
                    } catch (e: Exception) {
                        print("You need to enter a Long-type value between 0 and 1000: ")
                        marinecount = null
                    }
                }
            } while (marinecount == null)

            if (marinecount.isNotEmpty()) {
                element.getChapter().setMarinecount(marinecount.trim().toLong())
            }

        }

    }
}