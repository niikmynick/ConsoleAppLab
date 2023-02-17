package basicClasses

import exceptions.ChapterNameIsBlank
import exceptions.MarineCountIllegalValue

data class Chapter(
    private var name: String, //Поле не может быть null, Строка не может быть пустой
    private var marinecount: Long //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    ) {
    init {
        if (name.isBlank()) throw ChapterNameIsBlank("Name cannot be empty or blank")
        else if (marinecount !in 0..1000) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
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


}
