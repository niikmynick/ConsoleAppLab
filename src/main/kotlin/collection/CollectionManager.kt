package collection

import basicClasses.Chapter
import basicClasses.SpaceMarine
import exceptions.SpaceMarineIdAlreadyExists
import java.util.Date
import java.util.TreeSet

/**
 * A [TreeSet] collection of [SpaceMarine]
 * Implements methods used in commands
 * @property date Saves creation date
 */
class CollectionManager {
    private val collection = TreeSet<SpaceMarine>()
    private val date: Date = Date()

    fun getCollection(): TreeSet<SpaceMarine> {
        return collection
    }

    fun add(spaceMarine: SpaceMarine) {
        if (spaceMarine == this.getByID(spaceMarine.getId())) throw SpaceMarineIdAlreadyExists("Space Marine" +
                "$spaceMarine cannot be added to collection as a Space Marine with this id already exists")
        collection.add(spaceMarine)
    }

    /**
     * Creates a formatted string with info about collection
     * @return Formatted string with size and [date] values
     */
    fun getInfo() : String {
        return "Tree Set of SpaceMarine: size=${collection.size}, date=${date}"
    }

    /**
     * Prints all elements of the collection
     */
    fun show(): MutableList<String> {
        if (collection.isEmpty()) {
            return mutableListOf("Collection is empty")
        } else {
            val output = mutableListOf<String>()
            for (spaceMarine in collection) {
                output.add(spaceMarine.toString())
            }
            return output
        }
    }

    /**
     * Updates values of an element
     */
    fun update(data: SpaceMarine, spaceMarine: SpaceMarine) {
        spaceMarine.setName(data.getName())
        spaceMarine.setCoordinates(data.getCoordinates())
        spaceMarine.setCategory(data.getCategory())
        spaceMarine.setChapter(data.getChapter())
        spaceMarine.setHealth(data.getHealth())
        spaceMarine.setLoyalty(data.getLoyalty())
        spaceMarine.setMeleeWeapon(data.getWeapon())
    }

    /**
     * Removes element
     * @param spaceMarine element in the collection
     */
    fun remove(spaceMarine: SpaceMarine) : Boolean {
        return collection.remove(spaceMarine)
    }

    fun clear() {
        collection.clear()
    }

    /**
     * Searches for element with provided [id]
     * @param id id of the element to search
     * @return Found element or null
     */
    fun getByID(id: Long) : SpaceMarine? {
        for (spaceMarine in collection) {
            if (spaceMarine.getId() == id) {
                return spaceMarine
            }
        }
        return null
    }

    /**
     * Prints all elements with provided [Chapter]
     * @param chapter Chapter searched in elements of collection
     */
    fun filterByChapter(chapter: Chapter): MutableList<String> {
        val result = mutableListOf<String>()

        for (spaceMarine in collection) {
            if (spaceMarine.getChapter() == chapter) {
                result.add(spaceMarine.toString())
            }
        }
        return result
    }

}
