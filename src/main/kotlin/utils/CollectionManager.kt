package utils

import basicClasses.Chapter
import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
import utils.readers.*
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.Date
import java.util.TreeSet
import com.charleskorn.kaml.Yaml

/**
 * Collection manager
 *
 * @constructor Create Collection manager
 */
class CollectionManager : TreeSet<SpaceMarine>() {
    private val date: Date = Date()

    /**
     * Info
     *
     * @return
     */
    fun info() : String {
        return "Tree Set of SpaceMarine: size=${this.size}, date=${this.date}"
    }

    /**
     * Show collection
     *
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
     * Update element
     *
     * @param id
     */
    fun update(id : Long) {
        val element = this.getByID(id)
        if (element != null) {
            NameReader.update(element)
            CoordinatesCreator.update(element)
            HealthReader.update(element)
            LoyaltyReader.update(element)
            CategoryReader.update(element)
            WeaponReader.update(element)
            ChapterCreator.update(element)
        } else println("No element with Id=$id was found")

    }

    /**
     * Remove id
     *
     * @param id
     */
    fun removeID(id : Long) {
        val element = this.getByID(id)
        if (element != null) {
            this.remove(element)
        } else println("No element with Id=$id was found")
    }

    /**
     * Save collection to file
     *
     * @param filename
     * @return
     */
    fun save(filename:String) : Boolean {
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
     * Add min
     *
     * @param spaceMarine
     * @return
     */
    fun addMin(spaceMarine: SpaceMarine) : Boolean {
        return if (spaceMarine < this.first()) {
            this.add(spaceMarine)
            true
        } else false
    }

    /**
     * Remove greater
     *
     * @param spaceMarine
     * @return
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
     * Remove lower
     *
     * @param spaceMarine
     * @return
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
     * Unique weapons
     *
     * @return
     */
    fun uniqueWeapons() : Set<MeleeWeapon> {
        val weapons : MutableSet<MeleeWeapon> = mutableSetOf()
        for (element in this) {
            if (element.getMeleeWeapon() !in weapons) weapons.add(element.getMeleeWeapon())
        }
        return weapons
    }

    /**
     * Get by i d
     *
     * @param id
     * @return
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
     * Remove any element with chapter
     *
     * @param chapter
     * @return
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
     * Count melee weapons
     *
     * @param weapon
     * @return
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
     * Print by chapter
     *
     * @param chapter
     */
    fun printByChapter(chapter: Chapter) {
        for (element in this) {
            if (element.getChapter() == chapter) println(element)
        }
    }

}
