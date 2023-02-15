package commands.consoleCommands

import utils.CollectionManager

class Info : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        println(CollectionManager().info())
    }

}