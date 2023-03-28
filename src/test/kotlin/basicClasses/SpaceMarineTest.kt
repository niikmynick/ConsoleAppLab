package basicClasses

import exceptions.SpaceMarineHealthLowerThanZero
import exceptions.SpaceMarineIdLowerThanZero
import exceptions.SpaceMarineNameIsNullOrBlank
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class SpaceMarineTest {
    @Test
    @DisplayName("Creating default Space Marine and checking getters")
    fun `Create Default Space Marine`() {
        assertEquals(SpaceMarine().getName(), "Noname","Default name is wrong")
        assertEquals(SpaceMarine().getCoordinates(), Coordinates(0.0, 0),"Default coordinates are wrong")
        assertEquals(SpaceMarine().getHealth(), 1F,"Default health is wrong")
        assertEquals(SpaceMarine().getLoyalty(), false,"Default loyal is wrong")
        assertEquals(SpaceMarine().getCategory(), AstartesCategory.HELIX,"Default category is wrong")
        assertEquals(SpaceMarine().getWeapon(), MeleeWeapon.POWER_FIST,"Default weapon is wrong")
        assertEquals(SpaceMarine().getChapter(), Chapter("a",1),"Default chapter is wrong")
    }

    @Test
    @DisplayName("Setting name of a Space Marine")
    fun `Setting values in Space Marine`() {
        val sm = SpaceMarine()
        sm.setName("Juan")
        assertEquals(sm.getName(),"Juan", "Name was not set correctly")
    }

    @Test
    @DisplayName("Setting coordinates of a Space Marine")
    fun `Setting coordinates in Space Marine`() {
        val sm = SpaceMarine()
        val coordinates = mockk<Coordinates>()
        sm.setCoordinates(coordinates)
        assertEquals(sm.getCoordinates(), coordinates, "Coordinates were not set correctly")
    }

    @Test
    @DisplayName("Creating Space Marine with unacceptable values")
    fun `Creating Space Marine with unacceptable values`() {
        val coordinates = mockk<Coordinates>()
        val chapter = mockk<Chapter>()
        val localdate = mockk<LocalDate>()

        assertThrows<SpaceMarineNameIsNullOrBlank> {
            SpaceMarine(" ", coordinates, 1F, false, AstartesCategory.HELIX, MeleeWeapon.POWER_FIST, chapter)
        }
        assertThrows<SpaceMarineHealthLowerThanZero> {
            SpaceMarine("A", coordinates, -1F, false, AstartesCategory.HELIX, MeleeWeapon.POWER_FIST, chapter)
        }
        assertThrows<SpaceMarineIdLowerThanZero> {
            SpaceMarine(-1 ,"A", coordinates, localdate, 1F, false, AstartesCategory.HELIX, MeleeWeapon.POWER_FIST, chapter)
        }
    }
}