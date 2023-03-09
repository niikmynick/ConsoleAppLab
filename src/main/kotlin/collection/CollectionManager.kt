package collection

import basicClasses.Chapter
import basicClasses.SpaceMarine
import java.util.*


/**
 * Manages a collection of [SpaceMarine]
 * @property collection contains the collection
 * @property date Saves creation date
 */
class CollectionManager {
    private val collection = TreeSet<SpaceMarine>()
    private val date: Date = Date()

    fun getCollection(): TreeSet<SpaceMarine> {
        return collection
    }

    fun add(spaceMarine: SpaceMarine) {
        collection.add(spaceMarine)
    }

    /**
     * Creates a formatted string with info about collection
     * @return Formatted string with collection's size and [date] values
     */
    fun info(): String {
        return "Tree Set of SpaceMarine: size=${collection.size}, date=${date}"
    }

    /**
     * Returns a string containing all elements of the collection
     * @return String with elements separated with newline
     */
    fun show() : String {
        var output = ""
        if (collection.isEmpty()) {
            return "Collection is empty"
        } else {

            for (spaceMarine in collection) {
                output += (spaceMarine.toString() + "\n")
            }
        }
        return output
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

    /**
     * Clears collection
     */
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
     * Returns all elements with provided [Chapter]
     * @param chapter Chapter searched in elements of collection
     * @return All elements that contain provided [Chapter] separated with newline
     */
    fun filterByChapter(chapter: Chapter) : String{
        var output = ""
        for (spaceMarine in collection) {
            if (spaceMarine.getChapter() == chapter) {
                output += spaceMarine.toString() + "\n"
            }
        }
        return output
    }

}
