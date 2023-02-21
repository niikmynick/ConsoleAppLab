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

class CollectionManager : TreeSet<SpaceMarine>() {
    private val date: Date = Date()
    fun info() : String {
        return "Tree Set of SpaceMarine: size=${this.size}, date=${this.date}"
    }
    fun show() {
        if (this.isEmpty()) {
            println("Collection is empty")
        }
        for (element in this) {
            println(element)
        }
    }
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
    fun removeID(id : Long) {
        val element = this.getByID(id)
        if (element != null) {
            this.remove(element)
        } else println("No element with Id=$id was found")
    }
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
    fun addMin(spaceMarine: SpaceMarine) : Boolean {
        return if (spaceMarine < this.first()) {
            this.add(spaceMarine)
            true
        } else false
    }
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
    fun uniqueWeapons() : Set<MeleeWeapon> {
        val weapons : MutableSet<MeleeWeapon> = mutableSetOf()
        for (element in this) {
            if (element.getMeleeWeapon() !in weapons) weapons.add(element.getMeleeWeapon())
        }
        return weapons
    }
    fun getByID(id: Long) : SpaceMarine? {
        for (element in this) {
            if (element.getId() == id) {
                return element
            }
        }
        return null
    }
    fun removeAnyElementWithChapter(chapter: Chapter) : Boolean {
        for (element in this) {
            if (element.getChapter() == chapter) {
                remove(element)
                return true
            }
        }
        return false
    }
    fun countMeleeWeapons(weapon: MeleeWeapon) : Int {
        var count = 0
        for (element in this) {
            if (element.getMeleeWeapon() == weapon) {
                count++
            }
        }
        return count
    }
    fun printByChapter(chapter: Chapter) {
        for (element in this) {
            if (element.getChapter() == chapter) println(element)
        }
    }

}
