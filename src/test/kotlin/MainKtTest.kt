import commands.consoleCommands.Add
import commands.consoleCommands.Help
import commands.consoleCommands.Show
import utils.Console
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MainKtTest {

    @Test
    fun testSum() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()

        val expected = Help(console.commandInvoker.getCommandsList()).execute("Add", Scanner(System.`in`))
        assertEquals(expected, Add(console.collection).getInfo())
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

        val expectedPrint = Add(console.collection).execute("",scExpected)
        assertEquals(expectedPrint, "Space Marine F has been created and added to the list\n")
        val expectedShow = Show(console.collection).execute("", Scanner(System.`in`))
        assertEquals(expectedShow, Show(console.collection).execute("", Scanner(System.`in`)))
    }
}