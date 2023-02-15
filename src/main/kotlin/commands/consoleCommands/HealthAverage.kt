package commands.consoleCommands

import utils.CollectionManager

class HealthAverage : Command() {
    override fun writeInfo() {
        TODO("Not yet implemented")
    }

    override fun execute(vararg args: Any) {
        println("An average health value is ${CollectionManager().averageHealth()}")
    }
}