import commands.consoleCommands.Add
import commands.consoleCommands.Help
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
}