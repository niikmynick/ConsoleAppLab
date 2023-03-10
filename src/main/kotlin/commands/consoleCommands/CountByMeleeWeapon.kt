package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator
import exceptions.InvalidArgumentException

/**
 * Count by melee weapon command
 *
 * Prints the amount of elements with the provided weapon
 *
 * @property collection
 * @constructor Create command count_by_melee_weapon
 */
class CountByMeleeWeapon() : Command() {

    private lateinit var commandReceiver: CommandReceiver
    constructor(commandReceiver: CommandReceiver) : this() {
        this.commandReceiver = commandReceiver
    }
    override fun getInfo(): String {
        return "Prints the amount of elements with the provided weapon"
    }

    /**
     * Calls [CommandReceiver.countByWeapon]
     */
    override fun execute(args: List<String>) {
        if (Validator.verifyNoArgs(args)) {
            commandReceiver.countByWeapon()
        }  else throw InvalidArgumentException("Too many arguments were entered")
    }



}
