package commands.consoleCommands

import exceptions.SpaceMarineNotFound
import utils.CollectionManager
import utils.Creator
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
    override fun getInfo(): String {
        return "Deletes an element with a provided chapter value"
    }

    /**
     * Deletes first found Space Marine with a [basicClasses.Chapter] value equal to created
     * Prints whether a Space Marine was deleted or not
     * @param sc Is given to creator
     */
    override fun execute(argument:String, sc: Scanner): String {
        val chapter = Creator.createChapter(sc)
        val flag = collection.removeAnyElementWithChapter(chapter)

        return if (flag)
            "A Space Marine with Chapter == $chapter has been removed\n"
        else
            throw SpaceMarineNotFound("No element with chapter == $chapter was found\n")
    }

}
