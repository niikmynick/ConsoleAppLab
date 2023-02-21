package basicClasses

import exceptions.BlankChapterName
import exceptions.MarinesCountValueError
import kotlinx.serialization.Serializable

/**
 * Chapter classification
 *
 * Implement chapter scope for Space Marine object
 *
 * @name identify name of the chapter
 * @marinesCount answers how many marines
 */

@Serializable
data class Chapter(
    private var name: String, //Поле не может быть null, Строка не может быть пустой
    private var marinesCount: Long //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    ) {
    init {
        if (name.isBlank()) throw BlankChapterName("Name cannot be empty or blank")
        else if (marinesCount !in 0..1000) throw MarinesCountValueError("Marine Count value is not within 0 and 1000")
    }

    fun getName() : String{
        return this.name
    }
    fun getMarinesCount() : Long{
        return this.marinesCount
    }
    fun setName(name: String) {
        this.name  = name
    }
    fun setMarinesCount(marinesCount: Long) {
        this.marinesCount  = marinesCount
    }


}
