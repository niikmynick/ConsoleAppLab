package commands.consoleCommands

import utils.CollectionManager
import utils.readers.ChapterCreator
import java.util.Scanner

/**
 * Remove any chapter
 *
 * Deletes an element with a provided chapter value
 *
 * @property collection
 * @constructor Create command Remove any chapter
 */
class RemoveAnyChapter(private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Deletes an element with a provided chapter value")
    }

    /**
     * Deletes first found Space Marine with a [basicClasses.Chapter] value equal to created
     * Prints whether a Space Marine was deleted or not
     * @param sc Is given to creator
     */
    override fun execute(argument:String, sc: Scanner) {
        val chapter = ChapterCreator.create(sc)
        val flag = collection.removeAnyElementWithChapter(chapter)
        if (flag) println("A Space Marine with Chapter=$chapter has been removed")
        else println("No Space Marine has been removed")
    }

}
