package commands.consoleCommands

import utils.CollectionManager

class Update : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        val id = readln().trim().toInt()
        CollectionManager().update(id)
    }
}