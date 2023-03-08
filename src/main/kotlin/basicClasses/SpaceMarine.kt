package basicClasses

import exceptions.SpaceMarineHealthLowerThanZero
import exceptions.SpaceMarineIdLowerThanZero
import exceptions.SpaceMarineNameIsNullOrBlank
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.util.*

/**
 * Space marine
 *
 * @property id
 * @property name
 * @property coordinates
 * @property creationDate
 * @property health
 * @property loyal
 * @property category
 * @property meleeWeapon
 * @property chapter
 * @constructor Create Space marine
 */

@Serializable
data class SpaceMarine (
    /**
     * Defined automatically with [java.util.UUID.randomUUID], gets 64 most significant bits (Long) and makes it positive only
     */
    private val id: Long = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,//Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private var name: String, //Поле не может быть null, Строка не может быть пустой
    private var coordinates: Coordinates, //Поле не может быть null
    private val creationDate: String = LocalDate.now().toString(), //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private var health: Float?, //Поле может быть null, Значение поля должно быть больше 0
    private var loyal: Boolean,
    private var category: AstartesCategory, //Поле не может быть null
    private var meleeWeapon: MeleeWeapon, //Поле может быть null
    private var chapter: Chapter //Поле может быть null

    ) : Comparable<SpaceMarine>{
    /**
     * @constructor Creates SpaceMarine with user given parameters. Used in [utils.Creator]
     */
    constructor(name: String,
                coordinates: Coordinates,
                health: Float?,
                loyal: Boolean,
                category: AstartesCategory,
                meleeWeapon: MeleeWeapon,
                chapter: Chapter) : this((UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE), name, coordinates, LocalDate.now().toString(),health, loyal, category, meleeWeapon, chapter)

    /**
     * @constructor Creates SpaceMarine with default parameters
     */
    constructor() : this("Noname", Coordinates(0.0, 0), 1F, false, AstartesCategory.HELIX, MeleeWeapon.POWER_FIST, Chapter("a",1))

    init {
        if (name.isBlank()) throw SpaceMarineNameIsNullOrBlank("Name cannot be null, blank or empty")
        else if (health != null) {
            if (health!! <= 0) throw SpaceMarineHealthLowerThanZero("Health value cannot be below zero")
        }
        if (id <= 0) throw SpaceMarineIdLowerThanZero("Id value cannot be below zero")
    }


    override fun compareTo(other: SpaceMarine): Int {
            return this.id.compareTo(other.id)
        }
    override fun toString(): String {
        return "SpaceMarine(id=$id ,name=$name, coordinates=$coordinates, creationDate=$creationDate, health=$health, loyal=$loyal, category=$category, meleeWeapon=$meleeWeapon, chapter=$chapter)"
    }

    /**
     * Get id
     *
     * @return id
     */
    fun getId(): Long {
        return id
    }

    /**
     * Get name
     *
     * @return name
     */
    fun getName(): String {
        return name
    }

    /**
     * Get coordinates
     *
     * @return coordinates
     */
    fun getCoordinates(): Coordinates {
        return coordinates
    }

    /**
     * Get creation date
     *
     * @return creation date of this space marine
     */
    fun getCreationDate(): String {
        return creationDate
    }

    /**
     * Get health
     *
     * @return health
     */
    fun getHealth(): Float? {
        return health
    }

    /**
     * Get loyal
     *
     * @return loyalty
     */
    fun getLoyalty(): Boolean {
        return loyal
    }

    /**
     * Get category
     *
     * @return category
     */
    fun getCategory(): AstartesCategory {
        return category
    }

    /**
     * Get melee weapon
     *
     * @return weapon
     */
    fun getWeapon(): MeleeWeapon {
        return meleeWeapon
    }

    /**
     * Get chapter
     *
     * @return chapter
     */
    fun getChapter(): Chapter {
        return chapter
    }
    /**
     * Sets new name only if string is not empty
     */
    fun setName(string: String) {
        if (string.isNotEmpty()){
            this.name = string
        }
    }
    fun setCoordinates(coordinates: Coordinates) {
        this.coordinates = coordinates
    }
    /**
     * Set health
     *
     * Can receive null value
     *
     * @param health
     */
    fun setHealth(health: Float?) {
        this.health = health
    }
    fun setHealth(float: Float) {
        this.health = float
    }

    /**
     * Set loyal
     *
     * @param boolean
     */
    fun setLoyalty(boolean: Boolean) {
        this.loyal = boolean
    }

    /**
     * Set category
     *
     * @param category
     */
    fun setCategory(category: AstartesCategory) {
        this.category = category
    }

    /**
     * Set melee weapon
     *
     * @param meleeWeapon
     */
    fun setMeleeWeapon(meleeWeapon: MeleeWeapon) {
        this.meleeWeapon = meleeWeapon
    }

    /**
     * Set chapter
     *
     * @param chapter
     */
    fun setChapter(chapter: Chapter) {
        this.chapter = chapter
    }
}
