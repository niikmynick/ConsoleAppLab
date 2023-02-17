package basicClasses

import kotlinx.serialization.Serializable
import utils.serializers.ChapterSerializer
import utils.serializers.CoordinatesSerializer
import java.util.Date
import java.util.UUID
import kotlin.math.abs
import exceptions.SpaceMarineHealthLowerThanZero
import exceptions.SpaceMarineNameIsNullOrBlank

@Serializable
data class SpaceMarine (
    private var name: String, //Поле не может быть null, Строка не может быть пустой

    @Serializable(with = CoordinatesSerializer::class)
    private var coordinates: Coordinates, //Поле не может быть null

    private var health: Int?, //Поле может быть null, Значение поля должно быть больше 0
    private var loyal: Boolean,
    private var category: AstartesCategory, //Поле не может быть null
    private var meleeWeapon: MeleeWeapon, //Поле может быть null

    @Serializable(with = ChapterSerializer::class)
    private var chapter: Chapter //Поле может быть null

    ) : Comparable<SpaceMarine>{
    init {
        if (name.isNullOrBlank()) throw SpaceMarineNameIsNullOrBlank("Name cannot be null, blank or empty")
        else if (health != null) {
            if (health!! <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be lower than zero")
        }
    }
    private val id: Int = abs(UUID.randomUUID().hashCode()) //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private val creationDate:String = Date().toString() //Поле не может быть null, Значение этого поля должно генерироваться автоматически


    override fun compareTo(other: SpaceMarine): Int {
            return this.name.compareTo(other.name)
        }
    override fun toString(): String {
        return "SpaceMarine(id=$id ,name=$name, coordinates=$coordinates, creationDate=$creationDate, health=$health, loyal=$loyal, category=$category, meleeWeapon=$meleeWeapon, chapter=$chapter)"
    }

    fun getId(): Int {
        return id
    }
    fun getName(): String {
        return name
    }
    fun getCoordinates(): Coordinates {
        return coordinates
    }
    fun getCreationDate(): String {
        return creationDate
    }
    fun getHealth(): Int? {
        return health
    }
    fun getLoyal(): Boolean {
        return loyal
    }
    fun getCategory(): AstartesCategory {
        return category
    }
    fun getMeleeWeapon(): MeleeWeapon {
        return meleeWeapon
    }
    fun getChapter(): Chapter {
        return chapter
    }

    fun setName(string: String) {
        if (string.isNotEmpty()){
            this.name = string
        }
    }
    fun setCoordinates(coordinates: Coordinates) {
        this.coordinates = coordinates
    }
    fun setHealth(int: Int) {
        this.health = int
    }
    fun setLoyal(boolean: Boolean) {
        this.loyal = boolean
    }
    fun setCategory(category: AstartesCategory) {
        this.category = category
    }
    fun setMeleeWeapon(meleeWeapon: MeleeWeapon) {
        this.meleeWeapon = meleeWeapon
    }
    fun setChapter(chapter: Chapter) {
        this.chapter = chapter
    }


}
