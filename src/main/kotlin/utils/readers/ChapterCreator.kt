package utils.readers

import basicClasses.Chapter
import basicClasses.SpaceMarine
import exceptions.MarineCountIllegalValue
import exceptions.SpaceMarineHealthLowerThanZero

class ChapterCreator {
    companion object {
        fun create() : Chapter {
            println("Enter name of the Chapter: ")
            var name:String = readln().trim()

            while (name.isEmpty()) {
                println("You need to enter name of the Chapter: ")
                name = readln().trim()
            }

            println("Enter amount of Space Marines: ")
            var marinecount : Long = -1
            do {
                try {
                    marinecount = readln().trim().toLong()
                    if (marinecount !in 0..1000) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
                } catch (e: Exception) {
                    println("You need to enter Long-type value of Space Marines amount: ")
                }

            } while (marinecount !in 0..1000)

            return Chapter(name, marinecount)
        }
        fun update(element :SpaceMarine) {
            println("Enter name of the Chapter (press enter to save existing parameter): ")
            val name:String = readln()
            if (name.isNotEmpty()) {
                element.getChapter().setName(name.trim())
            }

            println("Enter amount of Space Marines (press enter to save existing parameter): ")


            var marinecount : String? = null
            do {
                marinecount = readln()
                if (marinecount.isNotEmpty()) {
                    try {
                        marinecount.trim().toLong()
                        if (marinecount.trim().toLong() !in 0..1000) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
                    } catch (e: Exception) {
                        println("You need to enter Long-type value of Space Marines amount: ")
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