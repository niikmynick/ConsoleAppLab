package Utils

class Console {
    fun startInteractiveMode() {
        println("Waiting for user command ...")
        do {
            print("$  ")
            val input = readln().split(" ")
            val command = input[0].trim().lowercase()

            var arg1: String = "000000"
            var arg2: String
            when (input.size) {
                2 -> arg1 = input[1].trim().lowercase()
                3 -> {arg1 = input[1].trim().lowercase()
                    arg2 = input[2].trim().lowercase()
                }
            }
        } while (command != "exit")
    }
}