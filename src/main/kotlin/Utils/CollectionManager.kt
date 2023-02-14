package Utils

import BasicClasses.SpaceMarine
import java.util.TreeSet

class CollectionManager(vararg list: SpaceMarine) : TreeSet<SpaceMarine>() {
    init {
        for (spaceMarine in list) {
            this.add(spaceMarine)
        }
    }

    fun info() {}
    fun show() {}
    fun update() {}
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
