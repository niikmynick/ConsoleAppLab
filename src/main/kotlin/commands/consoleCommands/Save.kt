package commands.consoleCommands

import utils.CollectionManager

class Save : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        val flag = CollectionManager().save()
        if (flag) {
            println("Collection was saved successfully")
        } else {
            println("Collection can not be saved. An error occurred ...")
        }
    }
}