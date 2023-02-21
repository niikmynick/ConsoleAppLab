package commands.consoleCommands

import utils.CollectionManager

/**
 * Command clear: Clears all elements in the collection
 * @param collection Gets current collection
 * @property info Has info about command
 */
class Clear (private val collection: CollectionManager) : Command() {
    override val info: String = "Clears all elements in the collection"

    /**
     * todo
     */
    override fun execute(argument:String) {
        if (collection.size > 0) {
            print("Are you sure? This operation will delete all elements [Y / N] ")
            var answer = readln().trim().lowercase()
            while ((answer != "y") and (answer != "n")) {
                print("Please, enter your answer in a correct form (Y - yes, N - no)")
                answer = readln().trim().lowercase()
            }
            if (answer == "y") {
                collection.clear()
                println("Done. There is nothing in the list now ... ")
            } else {
                println("All right")
            }
        } else {
            println("The collection is already empty ")
        }

    }
}