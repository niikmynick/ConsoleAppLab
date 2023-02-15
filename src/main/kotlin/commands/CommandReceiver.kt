package commands

import commands.consoleCommands.*

class CommandReceiver {
    fun help() = Help().execute()
    fun printInfo() = Info().execute()
    fun show() = Show().execute()
    fun add() = Add().execute()
    fun update() = Update().execute()
    fun removeID() = RemoveID().execute()
    fun clear() = Clear().execute()
    fun save() = Save().execute()
    fun executeFromFile() = ScriptFromFile().execute()
    fun exit() = Exit().execute()
    fun addMax() = AddMax().execute()
    fun removeGreater() = RemoveGreater().execute()
    fun removeLower() = RemoveLower().execute()
    fun printAverageHealth() = HealthAverage().execute()
    fun printGroupedByName() = GroupsByName().execute()
    fun printUniqueWeapons() = UniqueWeapons().execute()
}