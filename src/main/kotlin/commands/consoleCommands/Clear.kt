package commands.consoleCommands

import basicClasses.SpaceMarine
import java.util.*

/**
 * Clear
 *
 * Clears all elements in the collection
 * 
 * @property collection
 * @constructor Create command Clear
 */
class Clear(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Clears all elements in the collection"
    }

    /**
     * Clears all elements in the collection
     * @param sc Is where a new line is gotten
     */
    override fun execute(argument:String, sc: Scanner): String  {
        return if (collection.size > 0) {
            collection.clear()
            "Done. There is nothing in the collection now ...\n"
        } else {
            "The collection is already empty\n"
        }

//        if (collection.size > 0) {
//            print("Are you sure? This operation will delete all elements [Y / N] ")
//            var answer = sc.nextLine().trim().lowercase()
//            while ((answer != "y") and (answer != "n")) {
//                print("Please, enter your answer in a correct form (Y - yes, N - no)")
//                answer = sc.nextLine().trim().lowercase()
//            }
//            if (answer == "y") {
//                collection.clear()
//                println("Done. There is nothing in the list now ... ")
//            }
//        } else {
//            println("The collection is already empty ")
//        }
    }
}