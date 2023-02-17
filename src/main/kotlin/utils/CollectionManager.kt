package utils

import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
import utils.readers.*
import java.util.Date
import java.util.TreeSet

class CollectionManager() : TreeSet<SpaceMarine>() {
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
    fun update(id : Int) {
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
    fun removeID(id : Int) {
        val element = this.getByID(id)
        if (element != null) {
            this.remove(element)
        } else println("No element with Id=$id was found")
    }
    fun save() : Boolean {
        TODO() // should return true if save is done and false if error
    }
    fun addMax(spaceMarine: SpaceMarine) : Boolean {
        if (spaceMarine > this.last()) {
            this.add(spaceMarine)
            return true
        } else return false
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
    fun averageHealth(): Int {
        var sum = 0
        for (element in this) {
            if (element.getHealth() != null) {
                sum += element.getHealth()!!
            }
        }
        return if (this.isNotEmpty()) sum / this.size
        else return 0

    }
    fun groupByName() {} // should print result
    fun uniqueWeapons() : Set<MeleeWeapon> {
        val weapons : MutableSet<MeleeWeapon> = mutableSetOf()
        for (element in this) {
            if (element.getMeleeWeapon() !in weapons) weapons.add(element.getMeleeWeapon())
        }
        return weapons
    }
    fun getByID(id: Int) : SpaceMarine? {
        for (element in this) {
            if (element.getId() == id) {
                return element
            }
        }
        return null
    }

}
