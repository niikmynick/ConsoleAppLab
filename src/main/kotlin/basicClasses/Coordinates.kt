package basicClasses

data class Coordinates (
    private var x: Double,
    private var y: Long //Поле не может быть null
    ) {

    fun getX() : Double {
        return this.x
    }
    fun getY() : Long {
        return this.y
    }
    fun setX(x: Double) {
        this.x = x
    }
    fun setY(y: Long) {
        this.y = y
    }

}