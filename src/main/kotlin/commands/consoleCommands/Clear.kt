package commands.consoleCommands

import utils.CollectionManager

class Clear : Command() {
    override fun writeInfo() {
        println("Очищает коллекцию")
    }

    override fun execute(argument:String) {
        if (CollectionManager().size > 0) {
            println("Are you sure? This operation would delete all information about created Space Marines [Y / N] ")
            var answer = readln().trim().lowercase()
            while ((answer != "y") or (answer != "n")) {
                println("Please, enter your answer in correct form (Y - yes, N - no)")
                answer = readln().trim().lowercase()
            }
            if (answer == "y") {
                CollectionManager().clear()
                println("Done. There is nothing in the list now ... ")
            } else {
                println("All right")
            }
        } else {
            println("There is nothing to delete ... ")
        }

    }
}