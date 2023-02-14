package utils

class Console {
    fun startInteractiveMode() {
        println("Waiting for user command ...")

        do {
            print("$  ")
            val input = readln().split(" ")
            val command = input[0].trim().lowercase()
        } while (command != "exit")
    }
}