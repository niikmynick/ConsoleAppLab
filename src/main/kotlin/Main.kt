import utils.Console

fun main(args: Array<String>) {
    System.setProperty("COLLECTION_FILENAME","collection.yaml")
    val console = Console()
    console.startInteractiveMode()
}
