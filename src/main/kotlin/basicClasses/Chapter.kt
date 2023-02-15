package basicClasses

data class Chapter(
    private var name: String, //Поле не может быть null, Строка не может быть пустой
    private var marinecount: Long //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    ) {
    init {
        if (name.isEmpty() or name.isBlank()) throw ChapterNameIsEmptyOrBlank("Name cannot be empty or blank")
        else if ((marinecount < 0) or (marinecount > 1000)) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
    }

    fun getName() : String{
        return this.name
    }
    fun getMarinecount() : Long{
        return this.marinecount
    }
    fun setName(name: String) {
        this.name  = name
    }
    fun setMarinecount(marinecount: Long) {
        this.marinecount  = marinecount
    }

    class ChapterNameIsEmptyOrBlank(message: String?) : Exception(message)
    class MarineCountIllegalValue(message: String?) : Exception(message)

}
