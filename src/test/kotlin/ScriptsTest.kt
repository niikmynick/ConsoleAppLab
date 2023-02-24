import commands.consoleCommands.ScriptFromFile
import utils.Console
import java.util.Scanner
import kotlin.test.Test
import kotlin.test.assertEquals

class ScriptsTest {
    @Test
    fun emptyScript() {
        System.setProperty("COLLECTION_FILENAME","collection.yaml")
        val console = Console()
        console.initialize()
        val scExpected = Scanner("")

        val testPrint = ScriptFromFile(console.commandInvoker).execute("empty.txt", scExpected)
        assertEquals("The file does not contain commands\n", testPrint)
    }
}