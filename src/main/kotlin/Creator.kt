import BasicClasses.Chapter
import BasicClasses.Coordinates
import BasicClasses.SpaceMarine

class Creator {
    fun createSpaceMarine(): SpaceMarine {
        print("Enter name:  ")
        val name = readln()
        print("Enter X: ")
        val x = readln().toDoubleOrNull()
        print("Enter Y: ")
        val y = readln().toLongOrNull()
        print("Enter health index:  ")
        val health = readln().toIntOrNull()
        print("Enter loyalty [frue / false]:  ")
        val loyal = readln().lowercase().toBooleanStrict()

        val category = categoryReader()
        print("Enter Melee weapon:  ")
        val weapon = weaponReader()
        print("Enter Chapter name:  ")
        val chapterName = readln()
        print("Enter marines count: ")
        val marineCount = readln().toLongOrNull()

        val person = SpaceMarine(name, Coordinates(x, y), health, loyal, category, weapon, Chapter(chapterName, marineCount))
        return person
    }

    fun createCoordinates() {

    }

    fun createChapter() {

    }
}