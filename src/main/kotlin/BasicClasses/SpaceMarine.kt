package BasicClasses

import java.util.Date
import Utils.Identificator

data class SpaceMarine(private val name: String, //Поле не может быть null, Строка не может быть пустой
    private val coordinates: Coordinates, //Поле не может быть null
    private val health: Int, //Поле может быть null, Значение поля должно быть больше 0
    private val loyal: Boolean,
    private val category: AstartesCategory, //Поле не может быть null
    private val meleeWeapon: MeleeWeapon, //Поле может быть null
    private val chapter: Chapter, //Поле может быть null
    ) {
    private val identificator = Identificator()

    private val id = identificator.generate() //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private val creationDate = Date() //Поле не может быть null, Значение этого поля должно генерироваться автоматически


    fun getId(): Int {
        return id
    }
    fun getCreationDate(): Date {
        return creationDate
    }

    fun getName(): String {
        return name
    }
}
