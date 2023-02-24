package commands.consoleCommands

import java.util.Scanner
import utils.CollectionManager
import utils.readers.ChapterCreator

/**
 * Filter by chapter
 *
 * Prints elements with the provided chapter
 *
 * @property collection
 * @constructor Create command Filter by chapter
 */
class FilterByChapter(private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Prints elements with the provided chapter")
    }

    /**
     * Creates a [basicClasses.Chapter] and prints all elements with such Chapter
     * @param sc Is given to creator
     */
    override fun execute(argument: String, sc: Scanner) {
        val chapter = ChapterCreator.create(sc)
        collection.printByChapter(chapter)
    }

}
