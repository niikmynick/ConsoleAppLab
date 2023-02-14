package Utils

import BasicClasses.*
import java.util.Date
// TODO: dont think is needed anymore
class Creator {
    fun createSpaceMarine(
        id: Int,
        name: String,
        coord: Coordinates,
        date: Date,
        health: Int?,
        loyal: Boolean,
        category: AstartesCategory,
        meleeWeapon: MeleeWeapon,
        chapter: Chapter
    ): SpaceMarine {




        return SpaceMarine(name, coord, date, health, loyal, category, meleeWeapon, chapter)
    }


}