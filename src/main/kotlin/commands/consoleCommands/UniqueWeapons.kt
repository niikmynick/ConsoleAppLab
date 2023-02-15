package commands.consoleCommands

import utils.CollectionManager

class UniqueWeapons : Command(){
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        println("Here is a list of weapons from our collection: ")
        for (weapon in CollectionManager().uniqueWeapons()) {
            println(weapon)
        }
    }
}