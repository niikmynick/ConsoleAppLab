package commands.consoleCommands

import utils.CollectionManager
import java.util.Scanner

/**
 * Clear
 *
 * Clears all elements in the collection
 * 
 * @property collection
 * @constructor Create command Clear
 */
class Clear (private val collection: CollectionManager) : Command() {
    override fun getInfo(): String {
        return "Clears all elements in the collection"
    }

    /**
     * Clears all elements in the collection
     * @param sc Is where a new line is gotten
     */
    override fun execute(argument:String, sc: Scanner) {
        if (collection.size > 0) {
            print("Are you sure? This operation will delete all elements [Y / N] ")
            var answer = sc.nextLine().trim().lowercase()
            while ((answer != "y") and (answer != "n")) {
                print("Please, enter your answer in a correct form (Y - yes, N - no)")
                answer = sc.nextLine().trim().lowercase()
            }
            if (answer == "y") {
                collection.clear()
                println("Done. There is nothing in the list now ... ")
            }
        } else {
            println("The collection is already empty ")
        }

    }
}