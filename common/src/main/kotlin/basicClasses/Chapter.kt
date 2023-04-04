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


}
