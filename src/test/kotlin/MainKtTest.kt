import commands.consoleCommands.Add
import commands.consoleCommands.Help
import commands.consoleCommands.ScriptFromFile
import utils.Console
import java.util.*
import kotlin.test.Test
import kotlin.test.*

internal class MainKtTest {
    @Test
    fun infoWorkTest() {
        val console = Console()
        console.initialize()

        val expected = Help(console.commandInvoker.getCommandsList()).execute("Add", Scanner(System.`in`))
        assertEquals(expected, Add(console.collection).getInfo())
    }

    @Test
    fun scriptWorkTest() {
        val console = Console()
        console.initialize()

        val expected = "SpaceMarine(id=7207247519133682951 ,name=F, coordinates=Coordinates(x=34.0, y=43), creationDate=2023-02-24, health=34.0, loyal=false, category=INCEPTOR, meleeWeapon=POWER_SWORD, chapter=Chapter(name=File, marinesCount=10))\n" +
                "SpaceMarine(id=8250334885235871569 ,name=ef, coordinates=Coordinates(x=34.0, y=43), creationDate=2023-02-24, health=34.0, loyal=false, category=INCEPTOR, meleeWeapon=POWER_SWORD, chapter=Chapter(name=File, marinesCount=10))\n" +
                "SpaceMarine(id=2443916435948391887 ,name=fewdcbuik, coordinates=Coordinates(x=34.0, y=43), creationDate=2023-02-24, health=34.0, loyal=false, category=INCEPTOR, meleeWeapon=POWER_SWORD, chapter=Chapter(name=File, marinesCount=10))\n" +
                "SpaceMarine(id=2786703493593189217 ,name=htrtnygnf, coordinates=Coordinates(x=34.0, y=43), creationDate=2023-02-24, health=34.0, loyal=false, category=INCEPTOR, meleeWeapon=POWER_SWORD, chapter=Chapter(name=File, marinesCount=10))\n"

        ScriptFromFile(console.commandInvoker).execute("script.txt", Scanner(System.`in`))

        assertNotEquals(expected, console.collection.show())
    }

    @Test
    fun multiUserWorkTest() {
        val console1 = Console()
        console1.initialize()

        val console2 = Console()
        console2.initialize()

        val expected = false
        assertEquals(expected, console1.commandInvoker == console2.commandInvoker)
    }
}