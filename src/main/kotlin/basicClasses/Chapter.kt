package basicClasses

import exceptions.ChapterNameIsBlank
import exceptions.MarineCountIllegalValue
import kotlinx.serialization.Serializable

/**
 * Chapter data class used as property in [SpaceMarine]
 *
 * @property name Cannot be empty or null
 * @property marineCount Has to be between 0 and 1000
 * @constructor Creates Chapter with [name] and [marineCount]
 */
@Serializable
data class Chapter(
    private var name: String, //Поле не может быть null, Строка не может быть пустой
    private var marineCount: Long //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    ) {
    init {
        if (name.isBlank()) throw ChapterNameIsBlank("Name cannot be empty or blank")
        else if (marineCount !in 0..1000) throw MarineCountIllegalValue("Marine Count value is not within 0 and 1000")
    }

    fun getName() : String{
        return this.name
    }
    fun getMarinecount() : Long{
        return this.marineCount
    }
    fun setName(name: String) {
        this.name  = name
    }
    fun setMarinecount(marinecount: Long) {
        this.marineCount  = marinecount
    }


}
