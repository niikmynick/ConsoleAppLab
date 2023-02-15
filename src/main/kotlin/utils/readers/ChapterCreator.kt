package utils.readers

import basicClasses.Chapter

class ChapterCreator {
    companion object {
        fun create() : Chapter {
            println("Enter name of the Chapter: ")
            var name:String = readln().trim()

            while (name == "") {
                println("You need to enter name of the Chapter: ")
                name = readln().trim()
            }

            println("Enter amount of Space Marines: ")
            var marineCount:Long = readln().trim().toLong()

            while (marineCount !in 1..1000) {
                println("You need to enter Long-type value of Space Marines amount: ")
                marineCount = readln().trim().toLong()
            }

            return Chapter(name, marineCount)
        }
    }
}