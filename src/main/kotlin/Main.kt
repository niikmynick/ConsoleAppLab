import basicClasses.*
import utils.CollectionManager

fun main(args: Array<String>) {
    val s = SpaceMarine("Juan", Coordinates(3.4, 34), 100, true, AstartesCategory.ASSAULT, MeleeWeapon.POWER_BLADE, Chapter("One",112))
    val t = SpaceMarine("Juan Pablo", Coordinates(3.4, 34), 100, true, AstartesCategory.ASSAULT, MeleeWeapon.POWER_BLADE, Chapter("One",112))
    val c = CollectionManager()
    c.add(s)
    c.add(t)
    c.info()
    c.show()
    c.update(s.getId())
    c.show()
//    val console = Console()
//    console.startInteractiveMode()
}
