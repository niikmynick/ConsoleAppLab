package basicClasses

data class Coordinates(
    private var x: Double,
    private var y: Long //Поле не может быть null
    ) {

    fun getx() : Double {
        return this.x
    }
    fun gety() : Long {
        return this.y
    }
    fun setx(x: Double) {
        this.x = x
    }
    fun sety(y: Long) {
        this.y = y
    }

}