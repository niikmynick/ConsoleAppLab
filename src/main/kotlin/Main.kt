import Utils.Console
import BasicClasses.*
import Utils.SpaceMarineCollection
import java.util.Date

fun main(args: Array<String>) {
    val a = SpaceMarine( "34", Coordinates(-455.0, 324343223434), 4, true, AstartesCategory.LIBRARIAN, MeleeWeapon.POWER_BLADE, Chapter("One", 34))
    val b = SpaceMarine( "fdg", Coordinates(-455.0, 324343223434), 4, true, AstartesCategory.LIBRARIAN, MeleeWeapon.POWER_BLADE, Chapter("One", 34))
    val c = SpaceMarine( "trytr", Coordinates(-455.0, 324343223434), 3, true, AstartesCategory.LIBRARIAN, MeleeWeapon.POWER_BLADE, Chapter("One", 34))
    val d = SpaceMarine( "asd", Coordinates(-455.0, 324343223434),5, true, AstartesCategory.LIBRARIAN, MeleeWeapon.POWER_BLADE, Chapter("One", 34))
    val e = SpaceMarine( "asd", Coordinates(-455.0, 324343223434),4, true, AstartesCategory.LIBRARIAN, MeleeWeapon.POWER_BLADE, Chapter("One", 34))
    val f = SpaceMarine( "ff", Coordinates(-455.0, 324343223434), null, true, AstartesCategory.LIBRARIAN, MeleeWeapon.POWER_BLADE, Chapter("One", 34))
    val g = SpaceMarine( "ffh", Coordinates(-455.0, 324343223434), 4, true, AstartesCategory.LIBRARIAN, MeleeWeapon.POWER_BLADE, Chapter("One", 34))
    g.setLoyal(false)
    println("$a, ${a.hashCode()}")
    println("$b, ${b.hashCode()}")
    println("$c, ${c.hashCode()}")
    println("$d, ${d.hashCode()}")
    println("$e, ${e.hashCode()}")
    println("$f, ${f.hashCode()}")
    println("$g, ${g.hashCode()}")
    println(f.compareTo(g))
    var coll = SpaceMarineCollection(a, b, c, d, e, f, g)
    for (i in coll) {
        println(i.getName())
    }
    for (i in coll) {
        println(i.getMeleeWeapon())
    }
    println("The average health is ${coll.getAverageHealth()}")


    val console = Console()
    console.startInteractiveMode()
}
