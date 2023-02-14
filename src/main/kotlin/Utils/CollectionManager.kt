package Utils

import BasicClasses.SpaceMarine
import java.util.TreeSet

class SpaceMarineCollection(vararg spaceMarine: SpaceMarine) : TreeSet<SpaceMarine>() {
    init {
        for(sm in spaceMarine) {
            this.add(sm)
        }
    }

    fun getAverageHealth(): Int {
        var sum = 0
        for (i in this) {
            if (i.getHealth() != null) {
                sum += i.getHealth()!!
            }
        }
        return sum / this.size
    }

}
