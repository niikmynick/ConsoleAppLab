package Commands

import Commands.ConsoleCommands.*

class CommandReceiver {
    fun help() {
        Help().execute()
    }
    fun printInfo() {}
    fun show() {}
    fun add() {
        Add().execute()
    }
    fun update() {}
    fun removeID() {}
    fun clear() {}
    fun save() {}
    fun executeFromFile() {}
    fun exit() {}
    fun addMax() {}
    fun removeGreater() {}
    fun removeLower() {}
    fun printAverageHealth() {}
    fun printGroupedByName() {}
    fun printUniqueWeapons() {}
}