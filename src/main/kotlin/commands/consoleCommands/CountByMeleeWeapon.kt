package commands.consoleCommands

import commands.CommandReceiver
import commands.utils.Validator

/**
 * Count by melee weapon
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
     * Prints the amount of Space Marines with the provided weapon
     */
    override fun execute(args: List<String>) {
        if (Validator.verify(args)) {
            commandReceiver.countByWeapon()
        }
    }



}
