package commands.consoleCommands

import utils.CollectionManager
import kotlin.reflect.typeOf

class RemoveID : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        val id = readln().trim().toInt()
        val name = CollectionManager().getByID(id).getName()
        CollectionManager().removeID(id)
        println("Space Marine $name has been deleted")
    }
}