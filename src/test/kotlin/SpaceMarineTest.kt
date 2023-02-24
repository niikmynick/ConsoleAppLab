import basicClasses.SpaceMarine
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate

class SpaceMarineTest {

    @Test
    fun compareTo() {
        val marine1 = SpaceMarine()
        val marine2 = SpaceMarine()
        assertFalse(marine2 == marine1)
    }

    @Test
    fun getDate() {
        val marine = SpaceMarine()
        println(LocalDate.parse(marine.getCreationDate()))
        assertFalse(LocalDate.parse(marine.getCreationDate()).isAfter(LocalDate.now()))
    }
}