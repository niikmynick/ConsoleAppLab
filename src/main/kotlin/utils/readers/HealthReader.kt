package utils.readers

class HealthReader {
    companion object {
        fun read(): Int {
            println("Enter health value: ")
            var health:Int = readln().trim().toInt()

            while (health <= 0) {
                println("You need to enter Int-type value of health > 0: ")
                health = readln().trim().toInt()
            }

            return health
        }
    }
}