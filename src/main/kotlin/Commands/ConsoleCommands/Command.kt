package Commands.ConsoleCommands

import java.util.NoSuchElementException

abstract class Command {
    abstract fun writeInfo()
    abstract fun execute(vararg args:Any)
}