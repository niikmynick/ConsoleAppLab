package commands.consoleCommands

import utils.CollectionManager
import utils.readers.ChapterCreator

/**
 * Remove any chapter
 *
 * @property collection
 * @constructor Create command Remove any chapter
 */
class RemoveAnyChapter(private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Deletes an element with a provided chapter value")
    }

    override fun execute(argument:String) {
        val chapter = ChapterCreator.create()
        val flag = collection.removeAnyElementWithChapter(chapter)
        if (flag) println("A Space Marine with Chapter=$chapter has been removed")
        else println("No Space Marine has been removed")
    }

}
