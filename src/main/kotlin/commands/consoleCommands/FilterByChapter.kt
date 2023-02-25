package commands.consoleCommands

import basicClasses.SpaceMarine
import utils.Creator
import java.util.*

/**
 * Filter by chapter
 *
 * Prints elements with the provided chapter
 *
 * @property collection
 * @constructor Create command Filter by chapter
 */
class FilterByChapter(private val collection: TreeSet<SpaceMarine>) : Command() {
    override fun getInfo(): String {
        return "Prints elements with the provided chapter"
    }

    /**
     * Creates a [basicClasses.Chapter] and prints all elements with such Chapter
     * @param sc Is given to creator
     */
    override fun execute(argument: String, sc: Scanner): String {
        val chapter = Creator.createChapter(sc)

        return collection.printByChapter(chapter)
    }

}
