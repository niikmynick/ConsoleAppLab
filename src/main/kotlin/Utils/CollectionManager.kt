package Utils

import BasicClasses.SpaceMarine
import Utils.Readers.NameReader
import java.util.Date
import java.util.TreeSet

class CollectionManager() : TreeSet<SpaceMarine>() {
    private val date: Date = Date()
    fun info() {
        println("Tree Set of SpaceMarine: size=${this.size}, date=${this.date}")
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
    fun removeID() {}
    fun save() {}
    fun addMax() {}
    fun removeGreater() {}
    fun removeLower() {}
    fun averageHealth(): Int {
        var sum = 0
        for (element in this) {
            if (element.getHealth() != null) {
                sum += element.getHealth()!!
            }
        }
        return sum / this.size
    }
    fun groupByName() {}
    fun uniqueWeapons() {}

}
