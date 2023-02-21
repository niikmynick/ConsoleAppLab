package commands.consoleCommands

import utils.CollectionManager
import utils.readers.ChapterCreator

/**
 * Command remove_any_by_chapter: Deletes an element with a provided chapter value
 * @param collection Current collection
 * @property info Has info about command
 */
class RemoveAnyChapter(private val collection: CollectionManager) : Command() {
    override val info: String = "Deletes an element with a provided chapter value"

    /**
     * todo
     */
    override fun execute(argument:String) {
        val chapter = ChapterCreator.create()
        val flag = collection.removeAnyElementWithChapter(chapter)
        if (flag) println("A Space Marine with Chapter=$chapter has been removed")
        else println("No Space Marine has been removed")
    }

}
