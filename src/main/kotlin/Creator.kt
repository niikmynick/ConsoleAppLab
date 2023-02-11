class Creator {
    fun createSpaceMarine() {
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
        val marinesCount = readln().toLongOrNull()
    }

    fun createCoordinates() {

    }

    fun createChapter() {

    }
}