package collection

import basicClasses.*
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.Date

class CollectionManagerTest {
    @Test
    @DisplayName("Creating empty CollectionManager")
    fun `Creating empty CollectionManager`() {
        assertEquals(CollectionManager().getInfo(), "Tree Set of SpaceMarine: size=0, date=${Date()}", "Incorrect info of CollectionManager")
    }

    @Test
    @DisplayName("Creating CollectionManager and adding SpaceMarines")
    fun `Creating CollectionManager and adding SpaceMarines`() {
        val sm1 = SpaceMarine()
        val sm2 = SpaceMarine()
        val collectionManager = CollectionManager()
        collectionManager.add(sm1)
        collectionManager.add(sm2)
        assertEquals("Tree Set of SpaceMarine: size=2, date=${Date()}", collectionManager.getInfo(), "Incorrect info of CollectionManager")
        }

    @Test
    @DisplayName("Showing CollectionManager contents")
    fun `Showing CollectionManager contents`() {
        val sm1 = SpaceMarine()
        val sm2 = SpaceMarine()
        val list = mutableListOf<String>(sm2.toString(), sm1.toString()).sort()
        val collectionManager = CollectionManager()
        collectionManager.add(sm1)
        collectionManager.add(sm2)
        val listActual = collectionManager.show().sort()
        assertEquals(list, listActual, "Wrong list of contents")
    }

    @Test
    @DisplayName("Updating a SpaceMarine in CollectionManager")
    fun `Updating a SpaceMarine in CollectionManager`() {
        val coordinates = mockk<Coordinates>()
        val chapter = mockk<Chapter>()
        val sm1 = SpaceMarine()
        val sm2 = SpaceMarine("AAAA", coordinates, 1F, false, AstartesCategory.HELIX, MeleeWeapon.POWER_FIST, chapter)
        CollectionManager().update(sm2, sm1)
        assertEquals(sm2.getName(), sm1.getName(), "Incorrect name")
        assertEquals(sm2.getCoordinates(), sm1.getCoordinates(), "Incorrect coordinates")
        assertEquals(sm2.getHealth(), sm1.getHealth(), "Incorrect health")
        assertEquals(sm2.getLoyalty(), sm1.getLoyalty(), "Incorrect loyalty")
        assertEquals(sm2.getCategory(), sm1.getCategory(), "Incorrect category")
        assertEquals(sm2.getWeapon(), sm1.getWeapon(), "Incorrect weapon")
        assertEquals(sm2.getChapter(), sm1.getChapter(), "Incorrect chapter")
    }
}
