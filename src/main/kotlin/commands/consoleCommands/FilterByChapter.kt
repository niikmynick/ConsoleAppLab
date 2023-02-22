package commands.consoleCommands

import utils.CollectionManager
import utils.readers.ChapterCreator
import java.util.*

/**
 * Command filter_by_chapter: "Prints elements with the provided chapter"
 * @param collection Current collection
 * @property info Has info about command
 */
class FilterByChapter(private val collection: CollectionManager) : Command() {
    override val info: String = "Prints elements with the provided chapter"

    /**
     * todo
     */
    override fun execute(argument: String, sc: Scanner) {
        val chapter = ChapterCreator.create(sc)
        collection.printByChapter(chapter)
    }

}
