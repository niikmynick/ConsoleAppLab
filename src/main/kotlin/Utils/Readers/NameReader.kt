package Utils.Readers

class NameReader : Reader() {
    companion object {
        fun read(): String {
            var name:String = readln().trim()

            while (name.equals(null)) {
                println("Enter name of the new Space Marine: ")
                name = readln().trim()
            }

            return name
        }
    }
}
