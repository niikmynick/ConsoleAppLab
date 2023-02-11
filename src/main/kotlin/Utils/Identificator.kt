package Utils

import java.util.*
import kotlin.random.Random

class Identificator {
    private val idSet = TreeSet<Int>()

    fun generate(): Int {
        var id = Random.nextInt()

        if (idSet.contains(id)) {
            while (idSet.contains(id)) {
                id = Random.nextInt()
            }
        }

        idSet.add(id)

        return id
    }

    fun getSet(): TreeSet<Int> {
        return idSet
    }
}