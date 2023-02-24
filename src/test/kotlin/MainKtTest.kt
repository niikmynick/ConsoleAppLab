import commands.consoleCommands.*
import utils.Console
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MainKtTest {

    @Test
    fun help() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()

        val TestAdd = Help(console.commandInvoker.getCommandsList()).execute("Add", Scanner(System.`in`))
        assertEquals(TestAdd, Add(console.collection).getInfo())

        val TestFilter = Help(console.commandInvoker.getCommandsList()).execute("filter_by_chapter", Scanner(System.`in`))
        assertEquals(TestFilter, FilterByChapter(console.collection).getInfo())

        val TestRemoveId = Help(console.commandInvoker.getCommandsList()).execute("remove_by_id", Scanner(System.`in`))
        assertEquals(TestRemoveId, RemoveID(console.collection).getInfo())
    }

    @Test
    fun show() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()

        val TestPrint = Show(console.collection).execute("", Scanner(System.`in`))
        val expectedShow = "SpaceMarine(id=4238139039642437786 ,name=Alex, coordinates=Coordinates(x=33.0, y=60), creationDate=2023-02-24, health=null, loyal=false, category=INCEPTOR, meleeWeapon=POWER_SWORD, chapter=Chapter(name=Duo, marinesCount=1))\n" +
                "SpaceMarine(id=5287538626690041959 ,name=Nick, coordinates=Coordinates(x=66.0, y=120), creationDate=2023-02-24, health=67.0, loyal=true, category=TACTICAL, meleeWeapon=LIGHTING_CLAW, chapter=Chapter(name=Solo, marinesCount=17))\n"
        assertEquals(TestPrint, expectedShow)

    }

    @Test
    fun addElement() {
        System.setProperty("COLLECTION_FILENAME","nofile")
        val console = Console()
        console.initialize()
        val scExpected = Scanner("F\n" +
                "34\n" +
                "43\n" +
                "34\n" +
                "false\n" +
                "inceptor\n" +
                "power_sword\n" +
                "File\n" +
                "10\n")

        val TestPrint = Add(console.collection).execute("",scExpected)
        assertEquals(TestPrint, "Space Marine F has been created and added to the list\n")
        val TestShow = Show(console.collection).execute("", Scanner(System.`in`))
        assertEquals(TestShow, Show(console.collection).execute("", Scanner(System.`in`)))
    }

    @Test
    fun clear() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()

        val TestPrint = Clear(console.collection).execute("", Scanner(System.`in`))
        assertEquals(TestPrint, "Done. There is nothing in the collection now ...\n")
        val TestShow = Show(console.collection).execute("", Scanner(System.`in`))
        assertEquals(TestShow, "Collection is empty\n")
    }
}