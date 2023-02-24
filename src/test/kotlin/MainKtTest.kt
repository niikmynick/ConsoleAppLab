import commands.consoleCommands.*
import utils.Console
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun help() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()

        val testAdd = Help(console.commandInvoker.getCommandsList()).execute("Add", Scanner(System.`in`))
        assertEquals(Add(console.collection).getInfo(), testAdd)

        val testFilter = Help(console.commandInvoker.getCommandsList()).execute("filter_by_chapter", Scanner(System.`in`))
        assertEquals(FilterByChapter(console.collection).getInfo(), testFilter)

        val testRemoveId = Help(console.commandInvoker.getCommandsList()).execute("remove_by_id", Scanner(System.`in`))
        assertEquals(RemoveID(console.collection).getInfo(), testRemoveId)
    }

    @Test
    fun show() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()

        val testPrint = Show(console.collection).execute("", Scanner(System.`in`))
        val expectedShow = "SpaceMarine(id=4238139039642437786 ,name=Alex, coordinates=Coordinates(x=33.0, y=60), creationDate=2023-02-24, health=null, loyal=false, category=INCEPTOR, meleeWeapon=POWER_SWORD, chapter=Chapter(name=Duo, marinesCount=1))\n" +
                "SpaceMarine(id=5287538626690041959 ,name=Nick, coordinates=Coordinates(x=66.0, y=120), creationDate=2023-02-24, health=67.0, loyal=true, category=TACTICAL, meleeWeapon=LIGHTING_CLAW, chapter=Chapter(name=Solo, marinesCount=17))\n"
        assertEquals(expectedShow, testPrint)

    }

    @Test
    fun addElement() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
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

        val testPrint = Add(console.collection).execute("",scExpected)
        assertEquals("Space Marine F has been created and added to the list\n", testPrint)
        val testShow = Show(console.collection).execute("", Scanner(System.`in`))
        assertEquals(Show(console.collection).execute("", Scanner(System.`in`)), testShow)
    }

    @Test
    fun clear() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()

        val testPrint = Clear(console.collection).execute("", Scanner(System.`in`))
        assertEquals("Done. There is nothing in the collection now ...\n", testPrint)
        val testShow = Show(console.collection).execute("", Scanner(System.`in`))
        assertEquals("Collection is empty\n", testShow)
    }

    @Test
    fun falseUpdate() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()
        val scExpected = Scanner("\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n")
        val id = 4238139039642437786

        val testPrint = Update(console.collection).execute(id.toString(), scExpected)
        assertEquals("Element with id == $id has been updated\n", testPrint)
        val testShow = Show(console.collection).execute("", Scanner(System.`in`))
        val expectedShow = "SpaceMarine(id=4238139039642437786 ,name=Alex, coordinates=Coordinates(x=33.0, y=60), creationDate=2023-02-24, health=null, loyal=false, category=INCEPTOR, meleeWeapon=POWER_SWORD, chapter=Chapter(name=Duo, marinesCount=1))\n" +
                "SpaceMarine(id=5287538626690041959 ,name=Nick, coordinates=Coordinates(x=66.0, y=120), creationDate=2023-02-24, health=67.0, loyal=true, category=TACTICAL, meleeWeapon=LIGHTING_CLAW, chapter=Chapter(name=Solo, marinesCount=17))\n"
        assertEquals(expectedShow, testShow)
    }

    @Test
    fun trueUpdate() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()
        val scExpected = Scanner("Nuevo Nombre\n" +
                "4\n" +
                "72\n" +
                "100\n" +
                "True\n" +
                "TACTICAL\n" +
                "LIGHTING_CLAW\n" +
                "First\n" +
                "\n")
        val id = 4238139039642437786

        val testPrint = Update(console.collection).execute(id.toString(), scExpected)
        assertEquals("Element with id == $id has been updated\n", testPrint)
        val testShow = Show(console.collection).execute("", Scanner(System.`in`))
        val expectedShow = "SpaceMarine(id=4238139039642437786 ,name=Nuevo Nombre, coordinates=Coordinates(x=4.0, y=72), creationDate=2023-02-24, health=100.0, loyal=true, category=TACTICAL, meleeWeapon=LIGHTING_CLAW, chapter=Chapter(name=First, marinesCount=1))\n" +
                "SpaceMarine(id=5287538626690041959 ,name=Nick, coordinates=Coordinates(x=66.0, y=120), creationDate=2023-02-24, health=67.0, loyal=true, category=TACTICAL, meleeWeapon=LIGHTING_CLAW, chapter=Chapter(name=Solo, marinesCount=17))\n"
        assertEquals(expectedShow ,testShow)

    }

}