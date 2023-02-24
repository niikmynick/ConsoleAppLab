package basicClasses

import exceptions.BlankChapterName
import exceptions.MarinesCountValueError
import kotlinx.serialization.Serializable

/**
 * Chapter
 *
 * Data class used as property in [SpaceMarine]
 *
 * @property name Cannot be empty or null
 * @property marinesCount Has to be between 0 and 1000
 * @constructor Creates Chapter with [name] and [marinesCount]
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

    /**
     * Get name
     *
     * @return name of chapter
     */

    fun getName() : String{
        return this.name
    }

    /**
     * Get marines count
     *
     * @return marines count
     */

    fun getMarinesCount() : Long{
        return this.marinesCount
    }

    /**
     * Set name
     *
     * @param name
     */

    fun setName(name: String) {
        this.name  = name
    }

    /**
     * Set marines count
     *
     * @param marinesCount
     */

    fun setMarinesCount(marinesCount: Long) {
        this.marinesCount  = marinesCount
    }


}
