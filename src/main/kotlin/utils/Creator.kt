package utils

import basicClasses.SpaceMarine
import utils.readers.*
import java.util.Scanner

/**
 * Creator of Space Marines
 */
class Creator {
    /**
     * Gets [sc] and provides to readers/creators. Then creates a Space Marine with user prompt
     * @param sc Given to readers/creators
     * @return [SpaceMarine] object
     */
    fun createSpaceMarine(sc:Scanner): SpaceMarine {
        val name = NameReader.read(sc)
        val coordinates = CoordinatesCreator.create(sc)
        val health = HealthReader.read(sc)
        val loyal = LoyaltyReader.read(sc)
        val category = CategoryReader.read(sc)
        val weapon = WeaponReader.read(sc)
        val chapter = ChapterCreator.create(sc)

        return SpaceMarine(name, coordinates, health, loyal, category, weapon, chapter)
    }
}
