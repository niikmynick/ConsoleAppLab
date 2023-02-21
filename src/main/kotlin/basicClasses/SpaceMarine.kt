package basicClasses

import exceptions.SpaceMarineHealthLowerThanZero
import exceptions.SpaceMarineIdLowerThanZero
import exceptions.SpaceMarineNameIsNullOrBlank
import kotlinx.serialization.Serializable
import utils.serializers.LocalDateSerializer
import java.time.LocalDate
import java.util.*


@Serializable
data class SpaceMarine (
    private val id: Long = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,//Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private var name: String, //Поле не может быть null, Строка не может быть пустой


    private var coordinates: Coordinates, //Поле не может быть null
    @Serializable(with = LocalDateSerializer::class)
    private val creationDate: LocalDate = LocalDate.now(), //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private var health: Float?, //Поле может быть null, Значение поля должно быть больше 0
    private var loyal: Boolean,
    private var category: AstartesCategory, //Поле не может быть null
    private var meleeWeapon: MeleeWeapon, //Поле может быть null


    private var chapter: Chapter //Поле может быть null

    ) : Comparable<SpaceMarine>{
    constructor(name: String,
                coordinates: Coordinates,
                health: Float?,
                loyal: Boolean,
                category: AstartesCategory,
                meleeWeapon: MeleeWeapon,
                chapter: Chapter) : this((UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE), name, coordinates, LocalDate.now(),health, loyal, category, meleeWeapon, chapter)

    constructor() : this("Juan", Coordinates(0.0, 0), 1F, false, AstartesCategory.HELIX, MeleeWeapon.POWER_FIST, Chapter("a",1))

    init {
        if (name.isBlank()) throw SpaceMarineNameIsNullOrBlank("Name cannot be null, blank or empty")
        else if (health != null) {
            if (health!! <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be below zero")
        }
        if (id <= 0) throw SpaceMarineIdLowerThanZero("Id value cannot be below zero")
    }


    override fun compareTo(other: SpaceMarine): Int {
            return this.name.compareTo(other.name)
        }
    override fun toString(): String {
        return "SpaceMarine(id=$id ,name=$name, coordinates=$coordinates, creationDate=$creationDate, health=$health, loyal=$loyal, category=$category, meleeWeapon=$meleeWeapon, chapter=$chapter)"
    }

    fun getId(): Long {
        return id
    }
    fun getName(): String {
        return name
    }
    fun getCoordinates(): Coordinates {
        return coordinates
    }
    fun getCreationDate(): LocalDate {
        return creationDate
    }
    fun getHealth(): Float? {
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
    fun setHealth(float: Float?) {
        this.health = float
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
