package Utils

import BasicClasses.SpaceMarine
import Utils.Readers.*

class Creator {
    fun createSpaceMarine(): SpaceMarine {
        val name = NameReader.read()
        val coordinates = CoordinatesCreator.create()
        val health = HealthReader.read()
        val loyal = LoyalnessReader.read()
        val category = CategoryReader.read()
        val weapon = WeaponReader.read()
        val chapter = ChapterCreator.create()

        return SpaceMarine(name, coordinates, health, loyal, category, weapon, chapter)
    }
}
