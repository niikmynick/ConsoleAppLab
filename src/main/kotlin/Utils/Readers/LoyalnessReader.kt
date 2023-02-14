package Utils.Readers

class LoyalnessReader : Reader() {
    companion object {
        fun read() : Boolean {
            println("Enter loyalness [true / false]: ")
            var loyalness:Boolean = readln().trim().lowercase().toBooleanStrict()

            while (loyalness.equals(null)) {
                println("You need to enter Boolean-type valueof loyalness: ")
                loyalness = readln().trim().lowercase().toBooleanStrict()
            }

            return loyalness
        }
    }
}