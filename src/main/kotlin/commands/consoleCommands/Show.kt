package commands.consoleCommands

import utils.CollectionManager

class Show : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        CollectionManager().show()
    }

}