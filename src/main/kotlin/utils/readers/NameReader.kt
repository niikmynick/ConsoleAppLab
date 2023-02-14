package utils.readers

class NameReader {
    companion object {
        fun read(): String {
            println("Enter name of the new Space Marine: ")
            var name:String = readln().trim()

            while (name.equals(null)) {
                println("You need to enter the name: ")
                name = readln().trim()
            }

            return name
        }
    }
}
