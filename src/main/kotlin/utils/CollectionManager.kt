package utils

import basicClasses.Chapter
import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
import com.charleskorn.kaml.Yaml
import utils.readers.*
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.*

/**
 * A [TreeSet] collection of [SpaceMarine]
 * Implements methods used in commands
 * @property date Saves creation date
 */
class CollectionManager : TreeSet<SpaceMarine>() {
    private val date: Date = Date()

    /**
     * Creates a formatted string with info about collection
     * @return Formatted string with [size] and [date] values
     */
    fun info() : String {
        return "Tree Set of SpaceMarine: size=${this.size}, date=${this.date}"
    }

    /**
     * Prints all elements of the collection
     */
    fun show() {
        if (this.isEmpty()) {
            println("Collection is empty")
        }
        for (element in this) {
            println(element)
        }
    }

    /**
     * Updates values of an element equal to provided [id]
     * @param id id of the element to update
     * @param sc Given to updaters
     */
    fun update(id : Long, sc: Scanner) {
        val element = this.getByID(id)
        if (element != null) {
            NameReader.update(element, sc)
            CoordinatesCreator.update(element, sc)
            HealthReader.update(element, sc)
            LoyaltyReader.update(element, sc)
            CategoryReader.update(element, sc)
            WeaponReader.update(element, sc)
            ChapterCreator.update(element, sc)
        } else println("No element with Id=$id was found")

    }

    /**
     * Removes element with provided [id]
     * @param id id of the element to update
     */
    fun removeID(id : Long) {
        val element = this.getByID(id)
        if (element != null) {
            this.remove(element)
        } else println("No element with Id=$id was found")
    }

    /**
     * Saves elements of collection into file with provided [filename]
     * @param filename Name of the file
     * @return true if elements were saved, false an exception occurred
     */
    fun save(filename: String) : Boolean {
        return try {
            val file = FileOutputStream(filename)

            val output = OutputStreamWriter(file)
            for (element in this) {
                output.write(Yaml.default.encodeToString(SpaceMarine.serializer(), element))
                output.write("\n#ENDOFSPACEMARINE\n")
            }
            output.close()
            true
        } catch (e: Exception) {
            println(e.toString())
            false
        }

    }

    /**
     * Compares provided [spaceMarine] with the lowest element of the collection and adds it if provided is lower
     * @param spaceMarine Object to compare
     * @return true if [spaceMarine] was added, false if not
     */
    fun addMin(spaceMarine: SpaceMarine) : Boolean {
        return if (spaceMarine < this.first()) {
            this.add(spaceMarine)
            true
        } else false
    }

    /**
     * Removes all elements greater than provided [spaceMarine]
     * @param spaceMarine Object to compare
     * @return amount of elements removed
     */
    fun removeGreater(spaceMarine: SpaceMarine) : Int {
        var count = 0
        while (this.isNotEmpty()) {
            if (this.last() > spaceMarine) {
                this.remove(this.last())
                count++
            } else return count
        }
        return count
    }

    /**
     * Removes all elements lower than provided [spaceMarine]
     * @param spaceMarine Object to compare
     * @return amount of elements removed
     */
    fun removeLower(spaceMarine: SpaceMarine) : Int {
        var count = 0
        while (this.isNotEmpty()) {
            if (this.first() < spaceMarine) {
                this.remove(this.first())
                count++
            } else return count
        }
        return count

    }

    /**
     * Creates a list of unique [MeleeWeapon] found as values in elements of collection
     * @return List of unique [MeleeWeapon]
     */
    fun uniqueWeapons() : Set<MeleeWeapon> {
        val weapons : MutableSet<MeleeWeapon> = mutableSetOf()
        for (element in this) {
            if (element.getMeleeWeapon() !in weapons) weapons.add(element.getMeleeWeapon())
        }
        return weapons
    }

    /**
     * Searches for element with provided [id]
     * @param id id of the element to search
     * @return Found element or null
     */
    fun getByID(id: Long) : SpaceMarine? {
        for (element in this) {
            if (element.getId() == id) {
                return element
            }
        }
        return null
    }

    /**
     * Removes first found element with [Chapter] equal to provided
     * @param chapter Chapter searched in elements of collection
     * @return true if an element was removed, false if not
     */
    fun removeAnyElementWithChapter(chapter: Chapter) : Boolean {
        for (element in this) {
            if (element.getChapter() == chapter) {
                remove(element)
                return true
            }
        }
        return false
    }

    /**
     * Counts the amount of elements with provided [MeleeWeapon]
     * @param weapon MeleeWeapon searched in elements of collection
     * @return The amount of elements with provided weapon
     */
    fun countMeleeWeapons(weapon: MeleeWeapon) : Int {
        var count = 0
        for (element in this) {
            if (element.getMeleeWeapon() == weapon) {
                count++
            }
        }
        return count
    }

    /**
     * Prints all elements with provided [Chapter]
     * @param chapter Chapter searched in elements of collection
     */
    fun printByChapter(chapter: Chapter) {
        for (element in this) {
            if (element.getChapter() == chapter) println(element)
        }
    }

}
