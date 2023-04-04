package basicClasses

import kotlinx.serialization.Serializable

/**
 * Coordinates
 *
 * Class used as property in [SpaceMarine]
 * @property x
 * @property y
 * @constructor Create Coordinates
 */

@Serializable
data class Coordinates (
    private var x: Double, //Поле не может быть null
    private var y: Int
    )