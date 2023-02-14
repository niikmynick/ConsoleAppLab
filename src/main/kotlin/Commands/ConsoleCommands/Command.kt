package Commands.ConsoleCommands

import java.util.NoSuchElementException

abstract class Command {
    abstract fun writeInfo()
    abstract fun execute(element: Any)
}