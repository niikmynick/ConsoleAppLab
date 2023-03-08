import utils.Console
import java.io.File

/**
 * Main
 */
fun main() {
//    val user = System.currentTimeMillis()
//    File("collection${user}.yaml").createNewFile()
//    System.setProperty("COLLECTION_FILENAME","collection${user}.yaml")

    System.setProperty("COLLECTION_FILENAME","collection.yaml")
    val console = Console()
    console.initialize()
    console.startInteractiveMode()
}
