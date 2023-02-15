package utils

import basicClasses.MeleeWeapon
import basicClasses.SpaceMarine
import utils.readers.NameReader
import java.util.Collections
import java.util.Date
import java.util.TreeSet

class CollectionManager() : TreeSet<SpaceMarine>() {
    private val date: Date = Date()
    fun info() : String {
        return "Tree Set of SpaceMarine: size=${this.size}, date=${this.date}"
    }
    fun show() {
        for (element in this) {
            println(element)
        }
    }
    fun update(id : Int) {
        for (element in this) {
            if (element.getId() == id) {
                element.setName(NameReader.read())
            }
        }
    }
    fun removeID(id : Int) {}
    fun save() : Boolean {
        TODO() // should return true if save is done and false if error
    }
    fun addMax(spaceMarine: SpaceMarine) : Boolean {
        TODO() // should return true if element was added and false if not
    }
    fun removeGreater(spaceMarine: SpaceMarine) : Int {
        TODO() // should return amount of deleted marines
    }
    fun removeLower(spaceMarine: SpaceMarine) : Int {
        TODO() // should return amount of deleted marines
    }
    fun averageHealth(): Int {
        var sum = 0
        for (element in this) {
            if (element.getHealth() != null) {
                sum += element.getHealth()!!
            }
        }
        return sum / this.size
    }
    fun groupByName() {} // should print result
    fun uniqueWeapons() : Set<MeleeWeapon> {
        TODO() // should return list of unique weapons
    }
    fun getByID(id: Int) : SpaceMarine {
        TODO() // should find spaceMarine object in list by its id and return
    }

}
