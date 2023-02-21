package basicClasses

import kotlinx.serialization.Serializable

/**
 * Coordinates x y
 *
 * Implement coordinates scope for Space Marine object
 *
 * @x identify x-coordinates
 * @y identify y--coordinates
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