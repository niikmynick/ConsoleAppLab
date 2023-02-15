package basicClasses

data class Chapter(
    var name: String, //Поле не может быть null, Строка не может быть пустой
    var marinecount: Long //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    ) {
    init {
        if (name.isEmpty() or name.isBlank()) throw ChapterNameIsEmptyOrBlank("Name cannot be empty or blank")
        else if ((marinecount < 0) or (marinecount > 1000)) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
    }

    class ChapterNameIsEmptyOrBlank(message: String?) : Exception(message)
    class MarineCountIllegalValue(message: String?) : Exception(message)

}
