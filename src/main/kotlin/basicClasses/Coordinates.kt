package basicClasses

import kotlinx.serialization.Serializable


/**
 * Coordinates class used as property in [SpaceMarine]
 *
 * @property x Cannot be null
 * @property y Cannot be null
 * @constructor Creates Coordinates with [x] and [y]
 */
@Serializable
data class Coordinates (
    private var x: Double, //Поле не может быть null
    private var y: Int
    ) {

    fun getX() : Double {
        return this.x
    }
    fun getY() : Int {
        return this.y
    }
    fun setX(x: Double) {
        this.x = x
    }
    fun setY(y: Int) {
        this.y = y
    }

}