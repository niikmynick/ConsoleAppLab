package utils

import basicClasses.SpaceMarine
import utils.readers.*

class Creator {
    fun createSpaceMarine(): SpaceMarine {
        val name = NameReader.read()
        val coordinates = CoordinatesCreator.create()
        val health = HealthReader.read()
        val loyal = LoyaltyReader.read()
        val category = CategoryReader.read()
        val weapon = WeaponReader.read()
        val chapter = ChapterCreator.create()

        return SpaceMarine(name, coordinates, health, loyal, category, weapon, chapter)
    }
}
