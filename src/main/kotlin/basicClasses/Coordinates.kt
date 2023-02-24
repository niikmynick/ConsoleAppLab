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
    ) {
    /**
     * Get x
     *
     * @return x value
     */

    fun getX() : Double {
        return this.x
    }

    /**
     * Get y
     *
     * @return y value
     */

    fun getY() : Int {
        return this.y
    }

    /**
     * Set x
     *
     * @param x
     */

    fun setX(x: Double) {
        this.x = x
    }

    /**
     * Set y
     *
     * @param y
     */

    fun setY(y: Int) {
        this.y = y
    }

}