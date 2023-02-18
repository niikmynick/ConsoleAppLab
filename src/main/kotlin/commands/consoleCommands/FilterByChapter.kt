package commands.consoleCommands

import utils.CollectionManager
import utils.readers.ChapterCreator

class FilterByChapter(private val collection: CollectionManager) : Command() {
    override fun writeInfo() {
        println("Prints elements with the provided chapter")
    }

    override fun execute(argument: String) {
        val chapter = ChapterCreator.create()
        collection.printByChapter(chapter)
    }

}
